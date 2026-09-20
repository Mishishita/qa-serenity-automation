package com.qa.automation.api.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ListUsers {

    public static Task fromReqres() {
        return Task.where("Listar usuarios desde ReqRes", Get.resource("/api/users?page=2"));

    }

}
