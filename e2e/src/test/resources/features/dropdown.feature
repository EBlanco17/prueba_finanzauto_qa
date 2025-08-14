@Suite @Dropdown
Feature: CP02 - Validar la funcionalidad de Dropdown

  Background:
    Given el usuario navega a la página de dropdown

  @SelectOption
  Scenario: 1 - Seleccionar una opción del dropdown
    When el usuario selecciona la opción "Option 2" del dropdown
    Then la opción "Option 2" debe estar seleccionada en el dropdown
