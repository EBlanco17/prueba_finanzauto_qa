package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DownloadPage extends PageObject {
    public WebElementFacade getDownloadLink(String fileName) {
        return findBy("//a[text()='" + fileName + "']");
    }
}