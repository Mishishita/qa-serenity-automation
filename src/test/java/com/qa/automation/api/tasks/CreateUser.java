package com.qa.automation.api.tasks;

import com.qa.automation.api.models.UserRequest;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CreateUser {

    public static Task with(UserRequest userRequest) {
        return Task.where("crear un usuario en ReqRes", Post.to("/api/users")
                .with(request -> request.header("Content-Type", "application/json").body(userRequest)));

    }

}
