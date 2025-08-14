package com.co.finanzauto.e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class UploadPage extends PageObject {
    @FindBy(id = "file-upload")
    public WebElementFacade fileInput;

    @FindBy(id = "file-submit")
    public WebElementFacade submitButton;

    @FindBy(xpath = "//div[@id='content']//h3[contains(text(),'File Uploaded!')]")
    public WebElementFacade uploadedMessage;
}