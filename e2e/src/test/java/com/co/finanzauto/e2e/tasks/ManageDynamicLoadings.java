package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.DynamicLoadingPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
public class ManageDynamicLoadings {
    DynamicLoadingPage page;

    @Step("Abrir la primera página de Dynamic Loading")
    public void openFirstPage() {
        page.openAt("/dynamic_loading/1");
    }

    @Step("Hacer click en el botón Start")
    public void clickStartButton() {
        page.startButton.click();
        page.loadingMessage.waitUntilVisible();
        page.loadingMessage.waitUntilNotVisible();
    }

    @Step("Validar que el mensaje Hello World! sea visible")
    public void validateLoadingText() {
        Assert.assertTrue("El mensaje 'Hello World!' no es visible", page.message.isVisible());
        Assert.assertEquals("El mensaje no es el esperado", "Hello World!", page.message.getText());
    }

    @Step("Abrir la segunda página de Dynamic Loading")
    public void openSecondPage() {
        page.openAt("/dynamic_loading/2");
    }
}
