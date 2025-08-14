package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageCheckboxes;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class CheckboxesDefinition {

    @Steps
    ManageCheckboxes steps;

    @Given("el usuario navega a la página de checkboxes")
    public void elUsuarioNavegaAPaginaCheckboxes() {
        steps.openPage();
    }

    @When("el usuario selecciona el primer checkbox y desmarca el segundo")
    public void elUsuarioSeleccionaYDesmarca() {
        steps.selectFirstAndDeselectSecond();
    }

    @Then("ambos checkboxes deben estar con el primer seleccionado y el segundo desmarcado")
    public void validarCheckBoxes() {
        steps.validateSelection();
    }
}
