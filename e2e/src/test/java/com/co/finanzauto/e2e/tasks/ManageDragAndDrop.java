package com.co.finanzauto.e2e.tasks;

import com.co.finanzauto.e2e.pages.DragAndDropPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class ManageDragAndDrop {
    DragAndDropPage page;

    @Step("Abrir la página de Drag and Drop")
    public void openDragAndDropPage() {
        page.openAt("/drag_and_drop");
    }

    @Step("Arrastrar A sobre B")
    public void dragAtoB() {
        Actions actions = new Actions(page.getDriver());
        actions.dragAndDrop(page.columnA, page.columnB).perform();
    }

    @Step("Verificar que la posición se invirtió")
    public void verifySwapped() {
        String headerA = page.columnA.getText();
        String headerB = page.columnB.getText();
        Assert.assertEquals("B", headerA.trim());
        Assert.assertEquals("A", headerB.trim());
    }
}