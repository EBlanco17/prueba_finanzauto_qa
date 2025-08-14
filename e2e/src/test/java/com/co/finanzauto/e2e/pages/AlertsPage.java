package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AlertsPage extends PageObject {
    @FindBy(xpath = "//div[@id='content']/div/ul/li[1]/button")
    public WebElementFacade simpleAlertButton;

    @FindBy(xpath = "//div[@id='content']/div/ul/li[2]/button")
    public WebElementFacade confirmAlertButton;

    @FindBy(xpath = "//div[@id='content']/div/ul/li[3]/button")
    public WebElementFacade promptAlertButton;

    @FindBy(xpath = "//p[@id='result']")
    public WebElementFacade resultText;
}