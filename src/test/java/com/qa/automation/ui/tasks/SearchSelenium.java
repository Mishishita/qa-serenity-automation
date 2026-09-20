package com.qa.automation.ui.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.qa.automation.ui.targets.SeleniumHomePage.SEARCH_BUTTON;
import static com.qa.automation.ui.targets.SeleniumHomePage.SEARCH_INPUT;

public class SearchSelenium {

    public static Task forTerm(String searchTerm) {
        return Task.where("buscar " + searchTerm, Click.on(SEARCH_BUTTON),
                Enter.theValue(searchTerm).into(SEARCH_INPUT));
    }
}