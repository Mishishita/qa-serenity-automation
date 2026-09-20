package com.qa.automation.ui.actors;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class User {

    public static Actor named(String name){
        return Actor.named(name).whoCan(BrowseTheWeb.with(Serenity.getDriver()));
    }
    
}
