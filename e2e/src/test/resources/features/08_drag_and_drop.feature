@Suite @DragAndDrop
Feature: CP08 - Validar la funcionalidad de Drag and Drop

  @DragAndDrop
  Scenario: 1 - Intercambiar la posición de los elementos arrastrando
    Given el usuario navega a la página de drag and drop
    When el usuario arrastra el elemento A sobre el elemento B
    Then la posición de los elementos debe estar invertida