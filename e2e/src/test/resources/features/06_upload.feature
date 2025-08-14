@Suite @Upload
Feature: CP06 - Validar la funcionalidad de Upload

  @UploadFile
  Scenario: 1 - Subir un archivo correctamente
    Given el usuario navega a la página de upload
    When el usuario selecciona el archivo "archivoPrueba.txt" para subir
    And el usuario oprime el botón de subir archivo
    Then el mensaje "File Uploaded!" debe ser visible