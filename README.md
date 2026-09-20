# QA Serenity Automation

Proyecto de automatización de pruebas desarrollado con Java, Serenity BDD, Screenplay Pattern y Cucumber.

El proyecto incluye pruebas automatizadas de interfaz web para Selenium y pruebas de API para ReqRes. Los resultados de ejecución se generan mediante reportes de Serenity BDD.

## Tecnologías utilizadas

- Java 21
- Maven
- Serenity BDD
- Screenplay Pattern
- Cucumber
- Selenium WebDriver
- REST Assured
- JUnit
- Git

## Casos automatizados

### Pruebas Web - Selenium

- **TC-01:** Validar la carga de la página principal de Selenium y su título.
- **TC-02:** Validar la navegación hacia la documentación de Selenium.
- **TC-03:** Validar la búsqueda y correspondencia de los resultados.

### Pruebas API - ReqRes

- **TC-04:** Validar el listado de usuarios.
- **TC-05:** Validar la creación de un usuario.
- **TC-06:** Validar la actualización de un usuario.

## Estructura del proyecto

El proyecto utiliza el patrón Screenplay para separar las responsabilidades y facilitar el mantenimiento y escalabilidad de las pruebas.

```text
src/test
├── java
│   └── com.qa.automation
│       ├── api
│       │   ├── actors
│       │   ├── models
│       │   ├── questions
│       │   ├── stepdefinitions
│       │   └── tasks
│       ├── runners
│       └── ui
│           ├── actors
│           ├── questions
│           ├── stepdefinitions
│           ├── targets
│           └── tasks
└── resources
    └── features
        ├── api
        └── ui
```

### Componentes principales

- **Actors:** representan a los usuarios que ejecutan las acciones.
- **Tasks:** representan las acciones que realiza el actor.
- **Questions:** contienen las validaciones y permiten consultar el estado de la aplicación o respuesta de la API.
- **Targets:** identifican los elementos de la interfaz web.
- **Step Definitions:** conectan los escenarios escritos en Gherkin con la implementación en Java.
- **Models:** representan los objetos utilizados en las peticiones de API.
- **Features:** contienen los escenarios BDD escritos en Gherkin.
- **Runners:** permiten ejecutar las pruebas mediante Cucumber y Serenity BDD.

## Requisitos previos

Antes de ejecutar el proyecto, se requiere tener instalado:

- Java 21
- Maven 3.9 o superior
- Google Chrome
- Git

Para verificar las versiones instaladas:

```bash
java -version
mvn -version
git --version
```

## Instalación

1. Clonar el repositorio:

```bash
git clone https://github.com/Mishishita/qa-serenity-automation.git
```

2. Ingresar al directorio del proyecto:

```bash
cd qa-serenity-automation
```

3. Instalar las dependencias y compilar el proyecto:

```bash
mvn clean install
```

## Ejecución de pruebas

Para ejecutar todas las pruebas automatizadas:

```bash
mvn clean verify
```

El comando ejecuta los 6 casos automatizados:

- 3 casos de pruebas Web con Selenium.
- 3 casos de pruebas API con ReqRes.

Al finalizar la ejecución, Maven muestra el resultado de las pruebas y Serenity BDD genera el reporte automáticamente.

## Reporte Serenity BDD

Después de ejecutar las pruebas, el reporte HTML de Serenity BDD se genera en:

```text
target/site/serenity/index.html
```

El reporte incluye el resumen de ejecución, resultados de los escenarios y detalles de las pruebas automatizadas.

## Decisiones técnicas

- Se utilizó **Screenplay Pattern** para separar las responsabilidades de los actores, acciones y validaciones, facilitando el mantenimiento y reutilización del código.
- **Cucumber** se utilizó para definir los escenarios en Gherkin y mantener los casos de prueba legibles.
- **Selenium WebDriver** se utilizó para la automatización de las pruebas de interfaz web.
- **REST Assured**, integrado mediante Serenity Screenplay REST, se utilizó para la automatización de las pruebas de API.
- **Serenity BDD** se utilizó para la generación de reportes y el seguimiento de los resultados de ejecución.
- Los escenarios de API que requieren diferentes datos utilizan **Scenario Outline** para facilitar la parametrización.

## Observaciones sobre ReqRes

Durante las pruebas se observó que el endpoint de actualización `PUT /api/users/{id}` devuelve una respuesta `200 OK` incluso cuando el valor utilizado como `{id}` no corresponde a un usuario existente.

Por este motivo, la prueba de actualización valida el contenido de la respuesta (`name`, `job` y `updatedAt`) y el código de estado esperado, sin asumir un `404 Not Found` para identificadores inexistentes.

## Resultado de la ejecución

La ejecución completa del proyecto fue validada mediante:

```bash
mvn clean verify
```

Resultado:

- 6 pruebas ejecutadas
- 6 pruebas exitosas
- 0 fallos
- 0 errores
- Reporte Serenity BDD generado correctamente

## Reporte de ejecución

El reporte de ejecución generado por Serenity BDD se encuentra disponible en:

[Ver reporte Serenity BDD](https://mishishita.github.io/qa-serenity-automation/)