package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DragAndDropPage extends PageObject {
    @FindBy(id = "column-a")
    public WebElementFacade columnA;

    @FindBy(id = "column-b")
    public WebElementFacade columnB;
}