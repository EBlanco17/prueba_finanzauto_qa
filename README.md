# PRUEBA TÉCNICA - QA

Se desarrolló una suite completa de automatización de
pruebas para diferentes aplicaciones web públicas. Se implementó
pruebas de diferentes niveles (API, E2E, Performance). El objetivo es demostrar la capacidad para trabajar con
aplicaciones reales y crear una infraestructura de pruebas robusta.

## Clonación del proyecto

Desde una terminal, ejecute:

```
git clone https://github.com/EBlanco17/prueba_finanzauto_qa
```

## Estructura de carpetas

    api-tests/  #Pruebas de apis jsonplaceholder y reqres
    downloads/  #Donde se descargara el archivo en el test e2e /download
    e2e/    #Pruebas E2E de The Internet - Herokuapp
    performance/    #Pruebas de performance para JSONPlaceholder, ReqRes API, Swagger Petstore
    reports/    #Aqui se almacenan los reportes generados al ejecutas `docker compose up`
    .docker-compose.yml
    java-maven-edge.Dockerfile
    README.md

## Herramientas utilizadas

- Java JDK21
- Maven 9.8
- Edge Web Driver
- NodeJS 22.11
- K6 1.2.1
- Docker Desktop
- Windows 11 pro
- IntelliJ IDEA 2024.2
- Visual Studio Code
- ## GitHub Copilot

## ⚠️ Mas información de cada proyecto, en los diferentes READMES de cada uno.

---

## Docker

### Requisitos

- Docker Desktop (Linux containers / WSL2 activo).

#### Ejecución

Desde la raíz del repo:

```
    docker compose up --build
```

Para ejecutar por módulo:

```
docker compose up --build api-tests
docker compose up --build e2e-tests
docker compose up --build perf-tests
```

#### Reportes

- E2E (Serenity): reports/e2e/index.html
- API (Surefire): reports/api/index.html
- Performance (k6):
  JSON: reports/performance/json/_.json
  HTML: reports/performance/sites/_.html
  Notas

Los E2E corren en modo headless dentro de Docker.
La carpeta “downloads/” en la raíz se usa como destino de descargas en E2E.
