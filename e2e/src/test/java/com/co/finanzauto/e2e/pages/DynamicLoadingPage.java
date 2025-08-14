package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
public class DynamicLoadingPage  extends PageObject{

    @FindBy(xpath = "//div[@id='start']/button")
    public WebElementFacade startButton;

    @FindBy(xpath = "//div[@id='loading']")
    public WebElementFacade loadingMessage;

    @FindBy(xpath = "//div[@id='finish']/h4")
    public WebElementFacade message;
}
