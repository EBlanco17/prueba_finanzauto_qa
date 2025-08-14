package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.CheckboxesPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class ManageCheckboxes {

    CheckboxesPage page;

    @Step("Abrir la página de checkboxes")
    public void openPage() {
        page.openAt("/checkboxes");
    }

    @Step("Seleccionar el primer checkbox y desmarcar el segundo")
    public void selectFirstAndDeselectSecond() {
        if (!page.checkbox1.isSelected()) {
            page.checkbox1.click();
        }
        if (page.checkbox2.isSelected()) {
            page.checkbox2.click();
        }
    }

    @Step("Validar que el primero esté seleccionado y el segundo no")
    public void validateSelection() {
        Assert.assertTrue("El primer checkbox debería estar seleccionado", page.checkbox1.isSelected());
        Assert.assertFalse("El segundo checkbox debería estar desmarcado", page.checkbox2.isSelected());
    }
}
