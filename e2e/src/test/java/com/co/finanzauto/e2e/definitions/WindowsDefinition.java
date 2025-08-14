package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageWindows;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class WindowsDefinition {
    @Steps
    ManageWindows steps;

    @Given("el usuario navega a la página de windows")
    public void navegarWindows() {
        steps.openWindowsPage();
    }

    @When("el usuario hace clic en el enlace para abrir una nueva ventana")
    public void clickEnlaceNuevaVentana() {
        steps.clickNewWindowLink();
    }

    @Then("se debe abrir una nueva ventana con la url {string}")
    public void validarNuevaVentana(String urlEsperada) {
        steps.verifyNewWindowUrl(urlEsperada);
    }
}