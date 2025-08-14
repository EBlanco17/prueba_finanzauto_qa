@Suite @DynamicLoadings
Feature: CP05 - Validar las funcionalidades de carga dinámica

    @DynamicLoading1
    Scenario: 1 - Validar la carga dinámica de un elemento
      Given el usuario navega a la primer página de dynamic loading
      When el usuario hace click en el botón Start
      Then el usuario espera que el texto Hello World! sea visible

    @DynamicLoading2
    Scenario: 2 - Validar la carga dinámica de un elemento
      Given el usuario navega a la segunda página de dynamic loading
      When el usuario hace click en el botón Start
      Then el usuario espera que el texto Hello World! sea visible