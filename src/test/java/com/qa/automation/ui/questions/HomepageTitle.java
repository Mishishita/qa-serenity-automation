package com.qa.automation.ui.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class HomepageTitle implements Question<String> {

    @Override 
    public String answeredBy(Actor actor){
        return BrowseTheWeb.as(actor).getTitle();

    }

    public static HomepageTitle value(){
        return new HomepageTitle();
    }
    
}
