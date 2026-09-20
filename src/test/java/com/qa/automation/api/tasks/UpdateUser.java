package com.qa.automation.api.tasks;

import com.qa.automation.api.models.UserRequest;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class UpdateUser {

    public static Task with(String id, UserRequest userRequest) {
        return Task.where("actualizar el usuario con ID" + id, Put.to("/api/users/"+id)
                .with(request -> request.header("Content-Type", "application/json").body(userRequest)));

    }
}
