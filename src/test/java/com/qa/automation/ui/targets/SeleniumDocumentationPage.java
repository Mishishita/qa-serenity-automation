package com.qa.automation.ui.targets;

import net.serenitybdd.screenplay.targets.Target;

public class SeleniumDocumentationPage {

    public static final Target DOCUMENTATION_SECTION = Target.the("sección de documentación de Selenium")
            .locatedBy("//li[@id='m-documentation-li']");
}