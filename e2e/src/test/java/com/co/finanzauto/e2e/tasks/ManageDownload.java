package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.DownloadPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

import java.io.File;
import java.nio.file.Paths;

public class ManageDownload {
    DownloadPage page;

    @Step("Abrir la página de Download")
    public void openDownloadPage() {
        page.openAt("/download");
    }

    @Step("Descargar archivo")
    public void downloadFile(String archivo) {
        page.getDownloadLink(archivo).click();
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
    }

    @Step("Validar archivo descargado")
    public void validateFileDownloaded(String archivo) {
        String downloadPath = System.getProperty("user.home") + "/Downloads/" + archivo;
        File file = Paths.get(downloadPath).toFile();
        Assert.assertTrue("El archivo no fue descargado: " + archivo, file.exists());
    }
}