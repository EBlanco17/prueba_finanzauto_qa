package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckboxesPage extends PageObject {

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElementFacade checkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElementFacade checkbox2;

}

