package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.HoversPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class ManageHovers {
    HoversPage page;

    @Step("Abrir la página de Hovers")
    public void openHoversPage() {
        page.openAt("/hovers");
    }

    @Step("Pasar el mouse sobre el elemento {0}")
    public void hoverOnElement(int index) {
        Actions actions = new Actions(page.getDriver());
        actions.moveToElement(page.getUserElement(index)).perform();
    }

    @Step("Verificar que se muestre el texto esperado")
    public void verifyHoverText(String expectedText) {
        Assert.assertTrue("El texto no es visible", page.getUserNameText(expectedText).isVisible());
    }
}