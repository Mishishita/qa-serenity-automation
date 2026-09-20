Feature: Funcionalidades web de Selenium

    Como usuario quiero interactuar con el sitio web de Selenium
    Además, quiero verificar que sus funcionalidades principales funcionen correctamente

  Scenario: TC-01 - Validar la página de inicio de Selenium
    Given que el usuario accede al sitio web de Selenium
    Then la página de inicio debe cargarse correctamente
    And el título de la página debe ser "Selenium"

  Scenario: TC-02 - Navegar a la documentación de Selenium
    Given que el usuario accede al sitio web de Selenium
    When el usuario navega a la documentación
    Then la página de documentación debe cargarse correctamente

  Scenario: TC-03 - Validar el flujo de búsqueda en el sitio de Selenium
    Given que el usuario accede al sitio web de Selenium
    When el usuario busca "web driver"
    Then los resultados de búsqueda deben corresponder a "web driver"