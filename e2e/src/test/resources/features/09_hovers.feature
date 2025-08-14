@Suite @Hovers
Feature: CP09 - Validar la funcionalidad de Hovers

  @Hovers
  Scenario: 1 - Mostrar información al pasar el mouse sobre los elementos
    Given el usuario navega a la página de hovers
    When el usuario pasa el mouse sobre el elemento 1
    Then debe mostrarse el texto "name: user1"
    When el usuario pasa el mouse sobre el elemento 2
    Then debe mostrarse el texto "name: user2"
    When el usuario pasa el mouse sobre el elemento 3
    Then debe mostrarse el texto "name: user3"