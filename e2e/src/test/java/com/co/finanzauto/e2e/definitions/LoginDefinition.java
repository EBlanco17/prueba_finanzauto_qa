package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageLogin;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
public class LoginDefinition {

    @Steps
    ManageLogin steps;

    @Given("el usuario navega a la página de login")
    public void navegarPaginaLogin() {
        steps.openPage();
    }

    @When("el usuario ingresa un nombre de usuario válido")
    public void ingresarUnNombreDeUsuarioVálido() {
        steps.enterUsername("tomsmith");
    }

    @When("el usuario ingresa la contraseña correcta")
    public void ingresarLaContrasennaCorrecta() {
        steps.enterPassword("SuperSecretPassword!");
    }

    @And("el usuario oprime el botón de login")
    public void enviarFormularioLogin() {
        steps.submitLogin();
    }

    @Then("el usuario debe ser redirigido a la página de inicio")
    public void redirigirALaPaginaDeInicio() {
        steps.validateSuccessfulLogin();
    }

    @When("el usuario ingresa un nombre de usuario inválido")
    public void ingresarUnNombreDeUsuarioInválido() {
        steps.enterUsername("invalidUser");
    }

    @When("el usuario ingresa una contraseña incorrecta")
    public void ingresarUnaContraseñaIncorrecta() {
        steps.enterPassword("WrongPassword!");
        steps.submitLogin();
    }

    @Then("el usuario debe ver un mensaje de error indicando que las credenciales son incorrectas")
    public void verMensajeDeError() {
        steps.validateErrorMessage();
    }
}
