package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageDownload;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class DownloadDefinition {
    @Steps
    ManageDownload steps;

    @Given("el usuario navega a la página de download")
    public void navegarDownload() {
        steps.openDownloadPage();
    }

    @When("el usuario descarga el archivo {string}")
    public void descargarArchivo(String archivo) {
        steps.downloadFile(archivo);
    }

    @Then("el archivo {string} debe existir en la carpeta de descargas")
    public void validarArchivoDescargado(String archivo) {
        steps.validateFileDownloaded(archivo);
    }
}