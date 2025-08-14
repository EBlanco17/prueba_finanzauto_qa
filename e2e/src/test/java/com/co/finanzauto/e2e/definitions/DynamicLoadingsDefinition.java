package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageDynamicLoadings;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class DynamicLoadingsDefinition {
    @Steps
    ManageDynamicLoadings steps;

   @Given("el usuario navega a la primer página de dynamic loading")
    public void navegarPrimeraPagina() {
        steps.openFirstPage();
    }

    @When("el usuario hace click en el botón Start")
    public void iniciarCarga() {
        steps.clickStartButton();
    }

    @Then("el usuario espera que el texto Hello World! sea visible")
    public void validarMensajeCarga() {
        steps.validateLoadingText();
    }

    @Given("el usuario navega a la segunda página de dynamic loading")
    public void navegarSegundaPagina() {
        steps.openSecondPage();
    }
}
