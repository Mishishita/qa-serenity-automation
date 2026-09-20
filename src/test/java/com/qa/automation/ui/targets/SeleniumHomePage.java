package com.qa.automation.ui.targets;

import net.serenitybdd.screenplay.targets.Target;

public class SeleniumHomePage {

        public static final Target HOMEPAGE_HEADING = Target.the("título principal de la página de Selenium")
                        .locatedBy("//h1[contains(text(), \"Selenium automates browsers. That's it!\")]");

        public static final Target DOCUMENTATION_LINK = Target.the("enlace de documentación de Selenium")
                        .locatedBy("//a[@href='/documentation']");

        public static final Target SEARCH_BUTTON = Target.the("botón de búsqueda")
                        .locatedBy("//button[@aria-label='Search (Ctrl+K)']");

        public static final Target SEARCH_INPUT = Target.the("campo de búsqueda")
                        .locatedBy("//input[@id='docsearch-input']");

        public static final Target SEARCH_RESULTS = Target.the("resultados de búsqueda")
                        .locatedBy("//li[contains(@id,'docsearch-hits') and @role='option']//a");

}
