package com.qa.automation.api.stepdefinitions;

import com.qa.automation.api.actors.ApiUser;
import com.qa.automation.api.models.UserRequest;
import com.qa.automation.api.questions.ResponseStatus;
import com.qa.automation.api.questions.UserWasCreated;
import com.qa.automation.api.questions.UserWasUpdated;
import com.qa.automation.api.questions.UsersArePresent;
import com.qa.automation.api.tasks.CreateUser;
import com.qa.automation.api.tasks.ListUsers;
import com.qa.automation.api.tasks.UpdateUser;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.Actor;

public class ReqresSteps {

    private Actor user;
    private String userName;
    private String userJob;

    @Given("que el usuario realiza una petición para listar usuarios")
    public void userRequestsUserList() {
        user = ApiUser.named("API User");
        user.attemptsTo(ListUsers.fromReqres());

    }

    @Then("la respuesta debe tener un código 200")
    public void responseShouldHaveStatusCode200() {
        user.attemptsTo(Ensure.that(ResponseStatus.value()).isEqualTo(200));
    }

    @And("la respuesta debe contener usuarios")
    public void responseShouldContainsUsers() {
        user.attemptsTo(Ensure.that(UsersArePresent.value()).isTrue());
    }

    @Given("que el usuario realiza una petición para crear un usuario con nombre {string} y trabajo {string}")
    public void userCreate(String name, String job) {
        user = ApiUser.named("API User");

        userName = name;
        userJob = job;

        UserRequest userRequest = new UserRequest(name, job);
        user.attemptsTo(CreateUser.with(userRequest));

    }

    @Then("la respuesta debe tener un código 201")
    public void responseShouldHaveStatusCode201() {
        user.attemptsTo(Ensure.that(ResponseStatus.value()).isEqualTo(201));
    }

    @And("se debe haber creado el usuario correctamente")
    public void responseShouldHaveBeenCreated() {
        user.attemptsTo(Ensure.that(UserWasCreated.with(userName, userJob)).isTrue());
    }

    @Given("que el usuario realiza una petición para actualizar el usuario con ID {string}, nombre {string} y trabajo {string}")
    public void userUpdate(String id, String name, String job) {
        user = ApiUser.named("API User");

        userName = name;
        userJob = job;

        UserRequest userRequest = new UserRequest(name, job);
        user.attemptsTo(UpdateUser.with(id, userRequest));

    }

    @And("se debe haber actualizado el usuario correctamente")
    public void responseShouldHaveBeenUpdate() {
        user.attemptsTo(Ensure.that(UserWasUpdated.with(userName, userJob)).isTrue());
    }

}
