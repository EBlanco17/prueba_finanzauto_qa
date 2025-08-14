@Suite @Checkboxes
Feature: CP01 - Validar la funcionalidad de Checkboxes

  Background:
    Given el usuario navega a la página de checkboxes

  @SelectAndDeselect
  Scenario: 1 - Seleccionar el primer checkbox y desmarcar el segundo
    When el usuario selecciona el primer checkbox y desmarca el segundo
    Then ambos checkboxes deben estar con el primer seleccionado y el segundo desmarcado
