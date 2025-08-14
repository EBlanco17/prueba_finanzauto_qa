package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.AlertsPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class ManageAlerts {
    AlertsPage page;

    @Step("Abrir la página de JavaScript Alerts")
    public void openJavaScriptAlertsPage() {
        page.openAt("/javascript_alerts");
    }

    @Step("Oprimir el botón de alerta simple")
    public void clickSimpleAlertButton() {
        page.simpleAlertButton.click();
    }

    @Step("Oprimir el botón de confirmación")
    public void clickConfirmAlertButton() {
        page.confirmAlertButton.click();
    }

    @Step("Oprimir el botón de prompt")
    public void clickPromptAlertButton() {
        page.promptAlertButton.click();
    }

    @Step("Verificar el mensaje de la alerta")
    public void verifyAlertMessage(String expectedMessage) {
        Alert alert = page.getDriver().switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
    }

    @Step("Aceptar la alerta")
    public void acceptAlert() {
        page.getDriver().switchTo().alert().accept();
    }

    @Step("Cancelar la alerta")
    public void dismissAlert() {
        page.getDriver().switchTo().alert().dismiss();
    }

    @Step("Ingresar texto y aceptar la alerta")
    public void enterTextAndAccept(String text) {
        Alert alert = page.getDriver().switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    @Step("Verificar el resultado mostrado")
    public void verifyResultText(String expectedResult) {
        Assert.assertTrue(page.resultText.isVisible());
        Assert.assertEquals(expectedResult, page.resultText.getText());
    }

}