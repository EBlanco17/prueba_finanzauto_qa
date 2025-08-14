package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.DynamicControlsPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class ManageDynamicControls {

    DynamicControlsPage page;

    @Step("Abrir la página de Dynamic Controls")
    public void openPage() {
        page.openAt("/dynamic_controls");
    }

    // Checkbox flow
    @Step("Eliminar el checkbox")
    public void removeCheckbox() {
        if (page.checkbox.isPresent()) {
            page.checkboxButton.click();
            page.loadingMessage.waitUntilVisible();
            page.loadingMessage.waitUntilNotVisible();
        }
    }

    @Step("Validar que el mensaje aparezca después de eliminar")
    public void validateCheckboxMessage() {
        Assert.assertTrue("El mensaje de eliminación no apareció", page.checkboxMessage.isVisible());
    }

    @Step("Agregar nuevamente el checkbox")
    public void addCheckbox() {
        page.checkboxButton.click();
        page.loadingMessage.waitUntilVisible();
        page.loadingMessage.waitUntilNotVisible();
    }

    @Step("Validar que el checkbox reaparezca")
    public void validateCheckboxPresent() {
        Assert.assertTrue("El checkbox no reapareció", page.checkboxnew.isPresent());
    }

    // Input flow
    @Step("Habilitar el input")
    public void enableInput() {
        if (!page.inputField.isEnabled()) {
            page.inputButton.click();
            page.inputLoading.waitUntilVisible();
            page.inputLoading.waitUntilNotVisible();
        }
    }

    @Step("Validar que el input esté habilitado")
    public void validateInputEnabled() {
        Assert.assertTrue("El input debería estar habilitado", page.inputField.isEnabled());
    }
}
