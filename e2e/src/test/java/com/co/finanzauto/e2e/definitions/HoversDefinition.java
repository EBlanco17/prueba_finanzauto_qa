package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageHovers;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class HoversDefinition {
    @Steps
    ManageHovers steps;

    @Given("el usuario navega a la página de hovers")
    public void navegarHovers() {
        steps.openHoversPage();
    }

    @When("el usuario pasa el mouse sobre el elemento {int}")
    public void pasarMouseSobreElemento(int index) {
        steps.hoverOnElement(index);
    }

    @Then("debe mostrarse el texto {string}")
    public void verificarTexto(String texto) {
        steps.verifyHoverText(texto);
    }
}
