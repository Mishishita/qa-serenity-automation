package com.qa.automation.api.questions;

import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class UsersArePresent implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        List<?> users = LastResponse.received().answeredBy(actor).jsonPath().getList("data");

        return users != null && !users.isEmpty();
    }

    public static UsersArePresent value(){
        return new UsersArePresent();
    }

}
