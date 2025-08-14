package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.DropdownPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class ManageDropdown {

    DropdownPage page;

    @Step("Abrir la página de dropdown")
    public void openPage() {
        page.openAt("/dropdown");
    }

    @Step("Seleccionar la opción '{0}' del dropdown")
    public void selectOption(String optionText) {
        page.dropdown.selectByVisibleText(optionText);
    }

    @Step("Validar que la opción '{0}' esté seleccionada")
    public void validateOptionSelected(String expectedOption) {
        String selected = page.dropdown.getSelectedVisibleTextValue();
        Assert.assertEquals("La opción seleccionada no es la esperada", expectedOption, selected);
    }
}
