@Suite @Download
Feature: CP07 - Validar la funcionalidad de Download

  @DownloadFile
  Scenario: 1 - Descargar un archivo previamente subido
    Given el usuario navega a la página de download
    When el usuario descarga el archivo "archivoPrueba.txt"
    Then el archivo "archivoPrueba.txt" debe existir en la carpeta de descargas