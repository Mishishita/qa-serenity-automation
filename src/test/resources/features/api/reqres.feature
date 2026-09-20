Feature: Funcionalidades API - ReqRes
    Como usuario quiero interactuar con servicios de API ReqRes
    Además, quiero verificar que sus operaciones principales funcionen correctamente
  Scenario: TC-04 - Validar el listado de usuarios en ReqRes
    Given que el usuario realiza una petición para listar usuarios
    Then la respuesta debe tener un código 200
    And la respuesta debe contener usuarios

  Scenario Outline: TC-05 - Validar la creación de un usuario
    Given que el usuario realiza una petición para crear un usuario con nombre "<name>" y trabajo "<job>"
    Then la respuesta debe tener un código 201
    And se debe haber creado el usuario correctamente

    Examples:
      | name     | job    |
      | morpheus jose | leader |
  Scenario Outline: TC-06 - Validar la actualización de un usuario
    Given que el usuario realiza una petición para actualizar el usuario con ID "<id>", nombre "<name>" y trabajo "<job>"
    Then la respuesta debe tener un código 200
    And se debe haber actualizado el usuario correctamente

    Examples:
      | id | name     | job           |
      | 2  | morpheus | zion resident |
