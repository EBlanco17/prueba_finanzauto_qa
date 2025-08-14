package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HoversPage extends PageObject {
    public WebElementFacade getUserElement(int index) {
        // index inicia en 1
        return findBy("//div[@id='content']/div/div[" + index + "]");
    }

    public WebElementFacade getUserNameText(String userText) {
        return findBy("//div[@id='content']/div/div/div/h5[contains(text(),'" + userText + "')]");
    }
}