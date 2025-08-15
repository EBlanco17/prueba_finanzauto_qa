FROM maven:3.9.6-eclipse-temurin-21 AS base

# Instalar dependencias para Edge
RUN apt-get update && \
    apt-get install -y wget gnupg apt-transport-https curl unzip && \
    # Agregar repositorio de Microsoft Edge
    curl https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > microsoft.gpg && \
    install -o root -g root -m 644 microsoft.gpg /usr/share/keyrings/ && \
    sh -c 'echo "deb [arch=amd64 signed-by=/usr/share/keyrings/microsoft.gpg] https://packages.microsoft.com/repos/edge stable main" > /etc/apt/sources.list.d/microsoft-edge.list' && \
    apt-get update && \
    apt-get install -y microsoft-edge-stable && \
    rm -rf /var/lib/apt/lists/* microsoft.gpg

# Descargar EdgeDriver compatible
RUN EDGE_VERSION=$(microsoft-edge --version | awk '{print $3}') && \
    DRIVER_VERSION=$(curl -s "https://msedgedriver.azureedge.net/LATEST_RELEASE_${EDGE_VERSION%.*}") && \
    wget "https://msedgedriver.azureedge.net/${DRIVER_VERSION}/edgedriver_linux64.zip" && \
    unzip edgedriver_linux64.zip && \
    mv msedgedriver /usr/bin/msedgedriver && \
    chmod +x /usr/bin/msedgedriver && \
    rm edgedriver_linux64.zip

WORKDIR /app
