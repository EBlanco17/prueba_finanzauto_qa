package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class WindowsPage extends PageObject {
    @FindBy(xpath = "//div[@id='content']/div/a[contains(text(), 'Click Here')]")
    public WebElementFacade newWindowLink;
}