package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.UploadPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class ManageUpload {
    UploadPage page;

    @Step("Abrir la página de Upload")
    public void openUploadPage() {
        page.openAt("/upload");
    }

    @Step("Seleccionar archivo para subir")
    public void selectFile(String archivo) {
        page.fileInput.sendKeys(System.getProperty("user.dir") + "/src/test/resources/files/" + archivo);
    }

    @Step("Oprimir botón de subir archivo")
    public void submitFile() {
        page.submitButton.click();
    }

    @Step("Validar mensaje de subida")
    public void validateUploadMessage(String mensaje) {
        page.uploadedMessage.waitUntilVisible();
        Assert.assertTrue(page.uploadedMessage.getText().contains(mensaje));
    }
}