package com.co.finanzauto.e2e.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.co.finanzauto.e2e.definitions",
        tags = "@DynamicLoadings",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class DynamicLoadingRunner {
}
