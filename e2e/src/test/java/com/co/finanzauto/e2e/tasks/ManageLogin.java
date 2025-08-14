package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
public class ManageLogin {

    LoginPage page;

    @Step("el usuario navega a la página de login")
    public void openPage() {
        page.openAt("/login");
    }


    public void enterUsername(String username) {
        page.usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        page.passwordField.sendKeys(password);
    }

    public void submitLogin() {
        page.submitButton.click();
    }

    public void validateSuccessfulLogin() {
        String currentUrl = page.getDriver().getCurrentUrl();
        Assert.assertTrue("El usuario no fue redirigido a la página de inicio",
                currentUrl.endsWith("/secure"));
    }

    public void validateErrorMessage() {
        String message = page.flashMessage.getText();
        Assert.assertTrue("El mensaje de error no es el esperado",
                message.contains("Your username is invalid!"));
    }
}
