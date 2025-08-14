@Suite @DynamicControls
Feature: CP03 - Validar la funcionalidad de Dynamic Controls

  Background:
    Given el usuario navega a la página de dynamic controls

  @RemoveAndAddCheckbox
  Scenario: 1 - Eliminar y volver a agregar el checkbox
    When el usuario elimina el checkbox
    Then el mensaje debe aparecer después de eliminar
    When el usuario agrega nuevamente el checkbox
    Then el checkbox debe estar visible nuevamente

  @EnableInput
  Scenario: 2 - Habilitar el input
    When el usuario habilita el input
    Then el input debe estar habilitado
