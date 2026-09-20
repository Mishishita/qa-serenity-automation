package com.qa.automation.ui.questions;

import com.qa.automation.ui.targets.SeleniumDocumentationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DocumentationIsLoaded implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return SeleniumDocumentationPage.DOCUMENTATION_SECTION
                .resolveFor(actor)
                .isVisible();
    }

    public static DocumentationIsLoaded value() {
        return new DocumentationIsLoaded();
    }
}
