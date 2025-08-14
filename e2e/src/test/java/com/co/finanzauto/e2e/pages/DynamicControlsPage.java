package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DynamicControlsPage extends PageObject {

    // Checkbox form
    @FindBy(xpath = "//*[@id='checkbox']/input")
    public WebElementFacade checkbox;

    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    public WebElementFacade checkboxButton;

    @FindBy(xpath = "//div[@id='loading'][contains(text(),'Wait for it... ')]")
    public WebElementFacade loadingMessage;

    @FindBy(xpath = "//form[@id='checkbox-example']/p[@id='message']")
    public WebElementFacade checkboxMessage;

    @FindBy(xpath = "//input[@id='checkbox']")
    public WebElementFacade checkboxnew;

    // Input form
    @FindBy(xpath = "//form[@id='input-example']/button[contains(text(),'Enable') or contains(text(),'Disable')]")
    public WebElementFacade inputButton;

    @FindBy(xpath = "//form[@id='input-example']/div[@id='loading']")
    public WebElementFacade inputLoading;

    @FindBy(xpath = "//form[@id='input-example']/input")
    public WebElementFacade inputField;

    @FindBy(xpath = "//form[@id='input-example']/p[@id='message']")
    public WebElementFacade inputMessage;
}
