package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageDropdown;
import io.cucumber.java.es.*;
import net.serenitybdd.annotations.Steps;

public class DropdownDefinition {

    @Steps
    ManageDropdown steps;

    @Dado("el usuario navega a la página de dropdown")
    public void navegarPaginaDropdown() {
        steps.openPage();
    }

    @Cuando("el usuario selecciona la opción {string} del dropdown")
    public void seleccionarOpcionDropdown(String opcion) {
        steps.selectOption(opcion);
    }

    @Entonces("la opción {string} debe estar seleccionada en el dropdown")
    public void validarOpcionSeleccionada(String opcionEsperada) {
        steps.validateOptionSelected(opcionEsperada);
    }
}
