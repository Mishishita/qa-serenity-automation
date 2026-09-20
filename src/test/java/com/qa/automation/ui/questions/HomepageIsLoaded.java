package com.qa.automation.ui.questions;

import com.qa.automation.ui.targets.SeleniumHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class HomepageIsLoaded implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return SeleniumHomePage.HOMEPAGE_HEADING.resolveFor(actor).isVisible();
    }

    public static HomepageIsLoaded value() {
        return new HomepageIsLoaded();
    }
    
}
