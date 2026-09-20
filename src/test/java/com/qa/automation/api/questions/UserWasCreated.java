package com.qa.automation.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

/**
 * UserWasCreated
 */
public class UserWasCreated implements Question<Boolean> {

  private final String expectedName;
  private final String expectedJob;

  public UserWasCreated(String expectedName, String expectedJob) {
    this.expectedName = expectedName;
    this.expectedJob = expectedJob;
  }

  @Override
  public Boolean answeredBy(Actor actor) {

    String name = LastResponse.received().answeredBy(actor).jsonPath().getString("name");
    String job = LastResponse.received().answeredBy(actor).jsonPath().getString("job");
    String id = LastResponse.received().answeredBy(actor).jsonPath().getString("id");
    String createdAt = LastResponse.received().answeredBy(actor).jsonPath().getString("createdAt");

    return expectedName.equals(name)
        && expectedJob.equals(job)
        && id != null && !id.isBlank()
        && createdAt != null
        && !createdAt.isBlank();
  }

  public static UserWasCreated with(String userName, String userJob) {
    return new UserWasCreated(userName, userJob);
  }

}
