package com.qa.automation.ui.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static com.qa.automation.ui.targets.SeleniumHomePage.DOCUMENTATION_LINK;

public class NavigateSelenium {

    public static Task toWebsite() {
        return Task.where(
                "navegar al sitio web de Selenium",
                Open.url("https://www.selenium.dev/"));
    }

    public static Task toDocumentation() {
        return Task.where(
                "navegar a la documentación de Selenium",
                Click.on(DOCUMENTATION_LINK));
    }
}