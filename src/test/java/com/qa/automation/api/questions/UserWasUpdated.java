package com.qa.automation.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class UserWasUpdated implements Question<Boolean> {

    private final String expectedName;
    private final String expectedJob;

    public UserWasUpdated(String expectedName, String expectedJob) {
        this.expectedName = expectedName;
        this.expectedJob = expectedJob;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String name = LastResponse.received().answeredBy(actor).jsonPath().getString("name");
        String job = LastResponse.received().answeredBy(actor).jsonPath().getString("job");
        String updatedAt = LastResponse.received().answeredBy(actor).jsonPath().getString("updatedAt");

        return expectedName.equals(name)
                && expectedJob.equals(job)
                && updatedAt != null
                && !updatedAt.isBlank();

    }

    public static UserWasUpdated with(String userName, String userJob) {
        return new UserWasUpdated(userName, userJob);
    }
}