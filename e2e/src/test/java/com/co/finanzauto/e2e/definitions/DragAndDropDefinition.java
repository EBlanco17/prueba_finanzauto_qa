package com.co.finanzauto.e2e.definitions;

import com.co.finanzauto.e2e.tasks.ManageDragAndDrop;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class DragAndDropDefinition {
    @Steps
    ManageDragAndDrop steps;

    @Given("el usuario navega a la página de drag and drop")
    public void navegarDragAndDrop() {
        steps.openDragAndDropPage();
    }

    @When("el usuario arrastra el elemento A sobre el elemento B")
    public void arrastrarAenB() {
        steps.dragAtoB();
    }

    @Then("la posición de los elementos debe estar invertida")
    public void verificarPosicion() {
        steps.verifySwapped();
    }
}