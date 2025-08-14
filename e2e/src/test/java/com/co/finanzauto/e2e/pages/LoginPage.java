package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
public class LoginPage extends PageObject{
    @FindBy(xpath = "//form[@id='login']//input[@id='username']")
    public WebElementFacade usernameField;

    @FindBy(xpath = "//form[@id='login']//input[@id='password']")
    public WebElementFacade passwordField;

    @FindBy(xpath = "//form[@id='login']//button[@type='submit']")
    public WebElementFacade submitButton;

    @FindBy(xpath = "//div[@id='flash-messages']/div[@id='flash']")
    public WebElementFacade flashMessage;
}
