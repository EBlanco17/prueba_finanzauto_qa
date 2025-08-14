package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageDynamicControls;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class DynamicControlsDefinition {

    @Steps
    ManageDynamicControls steps;

    @Given("el usuario navega a la página de dynamic controls")
    public void navegarPaginaDynamicControls() {
        steps.openPage();
    }

    // Checkbox steps
    @When("el usuario elimina el checkbox")
    public void eliminarCheckbox() {
        steps.removeCheckbox();
    }

    @Then("el mensaje debe aparecer después de eliminar")
    public void validarMensajeEliminacion() {
        steps.validateCheckboxMessage();
    }

    @When("el usuario agrega nuevamente el checkbox")
    public void agregarCheckbox() {
        steps.addCheckbox();
    }

    @Then("el checkbox debe estar visible nuevamente")
    public void validarCheckboxReaparece() {
        steps.validateCheckboxPresent();
    }

    // Input steps
    @When("el usuario habilita el input")
    public void habilitarInput() {
        steps.enableInput();
    }

    @Then("el input debe estar habilitado")
    public void validarInputHabilitado() {
        steps.validateInputEnabled();
    }
}
