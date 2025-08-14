package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageUpload;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class UploadDefinition {
    @Steps
    ManageUpload steps;

    @Given("el usuario navega a la página de upload")
    public void navegarUpload() {
        steps.openUploadPage();
    }

    @When("el usuario selecciona el archivo {string} para subir")
    public void seleccionarArchivo(String archivo) {
        steps.selectFile(archivo);
    }

    @When("el usuario oprime el botón de subir archivo")
    public void oprimirBotonSubir() {
        steps.submitFile();
    }

    @Then("el mensaje {string} debe ser visible")
    public void validarMensaje(String mensaje) {
        steps.validateUploadMessage(mensaje);
    }
}