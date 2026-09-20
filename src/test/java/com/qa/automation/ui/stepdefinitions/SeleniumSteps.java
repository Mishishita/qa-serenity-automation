package com.qa.automation.ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import com.qa.automation.ui.actors.User;
import com.qa.automation.ui.questions.HomepageTitle;
import com.qa.automation.ui.questions.SearchResultsContain;

import net.serenitybdd.screenplay.ensure.Ensure;
import com.qa.automation.ui.tasks.NavigateSelenium;
import com.qa.automation.ui.tasks.SearchSelenium;
import com.qa.automation.ui.questions.DocumentationIsLoaded;
import com.qa.automation.ui.questions.HomepageIsLoaded;

public class SeleniumSteps {

    private final Actor user = User.named("User");

    @Given("que el usuario accede al sitio web de Selenium")
    public void userOpenSeleniumWebsite() {
        user.attemptsTo(NavigateSelenium.toWebsite());

    }

    @Given("la página de inicio debe cargarse correctamente")
    public void homePageShoukdBeLoaded() {
        user.attemptsTo(Ensure.that(HomepageIsLoaded.value()).isTrue());

    }

    @Then("el título de la página debe ser {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        user.attemptsTo(Ensure.that(HomepageTitle.value()).isEqualTo(expectedTitle));

    }

    @When("el usuario navega a la documentación")
    public void userNavigatesToDocumentation() {
        user.attemptsTo(NavigateSelenium.toDocumentation());
    }

    @Then("la página de documentación debe cargarse correctamente")
    public void documentationPageShouldBeLoaded() {
        user.attemptsTo(
                Ensure.that(DocumentationIsLoaded.value()).isTrue());
    }

    @When("el usuario busca {string}")
    public void userSearches(String searchTerm) {
        user.attemptsTo(SearchSelenium.forTerm(searchTerm));
    }
    
    @Then("los resultados de búsqueda deben corresponder a {string}")
    public void searchShouldBeContain(String expectedText) {
        user.attemptsTo(
                Ensure.that(SearchResultsContain.theTerm(expectedText)).isTrue());
    }
}
