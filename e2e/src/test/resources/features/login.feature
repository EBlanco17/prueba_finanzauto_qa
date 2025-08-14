@Suite @Login
Feature: CP04 - Validar la funcionalidad de Login

  Background:
    Given el usuario navega a la página de login

  @LoginSuccess
  Scenario: 1 - Completar los campos de usuario y contraseña
    When el usuario ingresa un nombre de usuario válido
   When el usuario ingresa la contraseña correcta
    And el usuario oprime el botón de login
    Then el usuario debe ser redirigido a la página de inicio

  @LoginFailure
  Scenario: 2 - Completar los campos de usuario y contraseña incorrectos
      When el usuario ingresa un nombre de usuario inválido
      When el usuario ingresa una contraseña incorrecta
      And el usuario oprime el botón de login
      Then el usuario debe ver un mensaje de error indicando que las credenciales son incorrectas