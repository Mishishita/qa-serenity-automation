package com.qa.automation.api.actors;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ApiUser {

    public static Actor named(String name){
        return Actor.named(name).whoCan(CallAnApi.at("https://reqres.in"));
    }
    
}
