package com.qa.automation.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ResponseStatus implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return LastResponse.received()
                .answeredBy(actor)
                .statusCode();
    }

    public static ResponseStatus value() {
        return new ResponseStatus();
    }

}
