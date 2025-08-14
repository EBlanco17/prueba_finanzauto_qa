package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.WindowsPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

import java.util.Set;

public class ManageWindows {
    WindowsPage page;
    private String originalWindow;

    @Step("Abrir la página de Windows")
    public void openWindowsPage() {
        page.openAt("/windows");
    }

    @Step("Hacer clic en el enlace para abrir una nueva ventana")
    public void clickNewWindowLink() {
        originalWindow = page.getDriver().getWindowHandle();
        page.newWindowLink.click();
        // Esperar a que haya más de una ventana abierta
        page.waitFor("window handles", driver -> driver.getWindowHandles().size() > 1);
    }

    @Step("Verificar que la nueva ventana tiene la URL esperada")
    public void verifyNewWindowUrl(String expectedUrl) {
        Set<String> windowHandles = page.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                page.getDriver().switchTo().window(handle);
                break;
            }
        }
        Assert.assertEquals(expectedUrl, page.getDriver().getCurrentUrl());
    }
}