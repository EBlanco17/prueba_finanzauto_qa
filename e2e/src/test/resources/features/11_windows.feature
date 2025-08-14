@Suite @Windows
Feature: CP11 - Validar la funcionalidad de ventanas nuevas

  @Windows
  Scenario: 1 - Validar apertura de nueva ventana
    Given el usuario navega a la página de windows
    When el usuario hace clic en el enlace para abrir una nueva ventana
    Then se debe abrir una nueva ventana con la url "https://the-internet.herokuapp.com/windows/new"