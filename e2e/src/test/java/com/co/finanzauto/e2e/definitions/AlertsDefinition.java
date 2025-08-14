package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageAlerts;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class AlertsDefinition {
    @Steps
    ManageAlerts steps;

    @Given("el usuario navega a la página de javascript alerts")
    public void navegarPaginaAlerts() {
        steps.openJavaScriptAlertsPage();
    }

    @When("el usuario oprime el botón de alerta simple")
    public void oprimirBotonAlertaSimple() {
        steps.clickSimpleAlertButton();
    }

    @When("el usuario oprime el botón de confirmación")
    public void oprimirBotonConfirmacion() {
        steps.clickConfirmAlertButton();
    }

    @When("el usuario oprime el botón de prompt")
    public void oprimirBotonPrompt() {
        steps.clickPromptAlertButton();
    }

    @Then("debe mostrarse el mensaje {string}")
    public void verificarMensajeAlerta(String mensaje) {
        steps.verifyAlertMessage(mensaje);
    }

    @When("el usuario acepta la alerta")
    public void aceptarAlerta() {
        steps.acceptAlert();
    }

    @When("el usuario cancela la alerta")
    public void cancelarAlerta() {
        steps.dismissAlert();
    }

    @When("el usuario ingresa el texto {string} y acepta la alerta")
    public void ingresarTextoYAceptar(String texto) {
        steps.enterTextAndAccept(texto);
    }

    @Then("debe mostrarse el resultado {string}")
    public void verificarResultado(String resultado) {
        steps.verifyResultText(resultado);
    }

}