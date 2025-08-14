# Proyecto de Pruebas de Performance con k6

Este proyecto contiene scripts para pruebas de carga y performance sobre diferentes APIs usando [k6](https://k6.io/). Incluye la generación de reportes en formato HTML y JSON.

## Estructura del Proyecto

```
performance/
├── scripts/
│   ├── jsonplaceholder.js
│   ├── petstore.js
│   └── reqres.js
├── results/
│   |── sites/
│   |    ├── jsonplaceholder.html
│   |    ├── petstore.html
│   |    └── reqres.html
│   ├── json
│   |   ├── jsonplaceholder.json
│   |   ├── petstore.json
│   |   └── reqres.json
└── README.md
```

## Requisitos

- Node.js y npm
- k6 instalado globalmente ([descargar aquí](https://grafana.com/docs/k6/latest/set-up/install-k6/))

## Ejecución de los Tests

Cada script de test está en la carpeta `scripts/`. Para ejecutar un test y generar el archivo de resultados en JSON:

```powershell
k6 run scripts/<nombre_script>.js --out json=results/json/<nombre_resultado>.json
```

Por ejemplo:

```
k6 run scripts/petstore.js --out json=results/json/petstore.json
```

## Generación de Reportes HTML

Cada script incluye la función `handleSummary` y el import de `k6-reporter`, lo que permite generar automáticamente un reporte HTML al finalizar la prueba. El archivo HTML se guarda en `results/sites/`.

No necesitas comandos adicionales para el HTML, solo ejecuta el test y el archivo se genera automáticamente:

```
k6 run scripts/petstore.js
```

Esto crea `results/sites/petstore.html`.

## Explicación de los Scripts

- **jsonplaceholder.js**: Prueba la API de JSONPlaceholder.
- **petstore.js**: Prueba la API de Swagger Petstore.
- **reqres.js**: Prueba la API de Reqres.

## Métricas y Resultados

- Los archivos `.json` en `results/` contienen los datos crudos de la ejecución, útiles para análisis avanzado.
- Los archivos `.html` en `results/sites/` son reportes visuales generados automáticamente por el script usando `k6-reporter`.
- Las métricas personalizadas (como errores) se muestran en el reporte si se registran durante la prueba.

## Ejemplo de Ejecución Completa

1. Ejecuta el test:
   ```
   k6 run scripts/petstore.js --out json=results/json/petstore.json
   ```
2. Al finalizar, revisa el reporte HTML en `results/sites/petstore.html`.
3. El archivo JSON estará en `results/json/petstore.json`.
