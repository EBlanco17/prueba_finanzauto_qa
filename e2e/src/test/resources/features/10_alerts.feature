@Suite @JSAlerts
Feature: CP10 - Validar la funcionalidad de JavaScript Alerts

  @JSAlert
  Scenario: 1 - Validar alerta simple
    Given el usuario navega a la página de javascript alerts
    When el usuario oprime el botón de alerta simple
    Then debe mostrarse el mensaje "I am a JS Alert"
    And el usuario acepta la alerta
    Then debe mostrarse el resultado "You successfully clicked an alert"

  @JSConfirm
  Scenario: 2 - Validar alerta de confirmación
    Given el usuario navega a la página de javascript alerts
    When el usuario oprime el botón de confirmación
    Then debe mostrarse el mensaje "I am a JS Confirm"
    When el usuario acepta la alerta
    Then debe mostrarse el resultado "You clicked: Ok"
    When el usuario oprime el botón de confirmación
    Then debe mostrarse el mensaje "I am a JS Confirm"
    When el usuario cancela la alerta
    Then debe mostrarse el resultado "You clicked: Cancel"

  @JSPrompt
  Scenario: 3 - Validar alerta con prompt
    Given el usuario navega a la página de javascript alerts
    When el usuario oprime el botón de prompt
    Then debe mostrarse el mensaje "I am a JS prompt"
    When el usuario ingresa el texto "Hola Mundo" y acepta la alerta
    Then debe mostrarse el resultado "You entered: Hola Mundo"