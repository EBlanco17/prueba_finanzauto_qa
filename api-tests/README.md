# Proyecto de Pruebas Automatizadas de APIs (JsonPlaceholder & ReqRes)

Este proyecto contiene pruebas automatizadas para las APIs públicas de [JsonPlaceholder](https://jsonplaceholder.typicode.com/) y [ReqRes](https://reqres.in/), utilizando Java, Maven y RestAssured. Las pruebas validan esquemas de respuesta, casos negativos y límites de tasa.

## Estructura de Carpetas
    src/ 
    └── test/java/com/co/finanzauto/qa
        ├── base/ # Clases base para configuración de url 
        ├── jsonplaceholder/ # Pruebas para la API de JsonPlaceholder 
        └── reqres/ # Pruebas para la API de ReqRes 
        └── resources/ 
            └── schemas/ # Esquemas JSON para validación
## Requerimientos

- Java 21+
- Maven 3.8+
- Conexión a internet (para acceder a las APIs públicas)

## Ejecución de los Tests

Desde la raíz del proyecto, ejecuta:
```
mvn clean test
```
Esto compilará el proyecto y ejecutará todas las pruebas automatizadas.

## Generación y Visualización de Reportes

Para generar los reportes de las pruebas, ejecuta:
```
mvn surefire-report:report
```
Los reportes se generarán en `target/reports/surefire.html`. Puedes abrir este archivo en tu navegador para ver los resultados de las pruebas.

Para limpiar los reportes generados, ejecuta:
```
mvn clean
```

Para ejecutar pruebas específicas, puedes usar:
```
mvn -Dtest=NombreDeLaClaseDePrueba test
```
