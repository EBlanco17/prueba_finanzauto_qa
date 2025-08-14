//modifica este readme para que se noten los titulos y subtitulos
# Finanzauto E2E Tests

Este proyecto implementa pruebas automatizadas end-to-end (E2E) para validar funcionalidades de la aplicación the-internet.herokuapp.com usando Serenity BDD, Selenium WebDriver y Cucumber.

## Estructura de Carpetas

    src/
      test/
        java/
          com/co/finanzauto/e2e/
            definitions/   # Step Definitions de Cucumber
            pages/         # Page Objects
            runners/       # Runners de Cucumber/Serenity
            tasks/         # Clases de tareas (acciones de usuario)
        resources/
          features/        # Archivos .feature de Cucumber
    serenity.conf          # Configuración de Serenity y WebDriver
    pom.xml                # Dependencias y configuración de Maven

### Herramientas Utilizadas

* Java 21
* Maven : para gestión de dependencias y ejecución
* Serenity BDD : para reportes y estructura de pruebas
* Cucumber : para definición de escenarios en lenguaje natural
* Selenium WebDriver : para automatización de navegador
* WebDriverManager : para gestión automática de drivers
* JUnit 5 : para ejecución de pruebas

### Configuración de Entorno

Asegúrate de tener configurado el archivo `serenity.conf` con las propiedades necesarias para tu entorno, como el navegador a utilizar, URL base, etc. Un ejemplo básico podría ser:

```properties
webdriver {
  driver = edge
}
base.url = https://the-internet.herokuapp.com
```


### Ejecución de Pruebas
Para ejecutar todas las pruebas automatizadas:
```
mvn clean verify
```
Para ejecutar un runner específico:
```
mvn clean verify -Dtest=NombreDelRunner
```
Para ejecutar un escenario específico:
```
mvn clean verify -Dcucumber.options="--tags @tag_del_escenario"
```

### Generación de Reporte Serenity

Después de ejecutar las pruebas, genera el reporte Serenity con:
```
mvn serenity:aggregate
```
El reporte se encuentra en `target/site/serenity/index.html`.


