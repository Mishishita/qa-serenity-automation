package com.qa.automation.ui.questions;

import static com.qa.automation.ui.targets.SeleniumHomePage.SEARCH_RESULTS;

import java.util.List;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SearchResultsContain implements Question<Boolean> {

    private final String searchTerm;

    public SearchResultsContain(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> results = SEARCH_RESULTS.resolveAllFor(actor);

        return !results.isEmpty() && results.stream()
                .allMatch(result -> result.getText().toLowerCase().replaceAll("\\s", "")
                        .contains(searchTerm.toLowerCase().replaceAll("\\s", "")));

    }

    public static SearchResultsContain theTerm(String searchTerm) {
        return new SearchResultsContain(searchTerm);
    }

}
