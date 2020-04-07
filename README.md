
# Write and execute a JUnit test for a Java microservice based on MircoProfile and the OpenLiberty development mode

That blog post contains the technical basics: how to develop a JUnit test for the Authors microservice from the Cloud Native Starter example and run both the Authors microservice and JUnit test on OpenLiberty in the development mode.

That blog post isn't intended to be a blueprint, or a how to guide for writing JUnit tests or how to definition test organization, test strategy and so on. The objective is to get technically started along the concrete microservice example from the Cloud Native Starter project.

You can also visit the OpenLiberty tutorial "MicroProfile or Jakarta EE application" to start with.

The Authors microservice has one RESTful api endpoint called getAuthor. The endpoint provides one parameter for the Author name. The endpoint returns Author data in a JSON format.

You can also visit the [OpenLiberty tutorial "MicroProfile or Jakarta EE application"](https://openliberty.io/guides/microshed-testing.html#bootstrapping-your-application-for-testing) to start with.

The Authors microservice has one RESTful api endpoint called `getAuthor`. The endpoint provides one parameter for the Author name. The endpoint returns Author data in a JSON format.

**What do we need and how do we implement it?**

**We need to**
 
 * .. invoke the REST endpoint of the Authors 
 * .. microservice with a REST Client.
 * .. transform the JSON response of the REST endpoint to an Author data class
 * .. handle different values to invoke the REST Endpoint parameter for the Author name to run tests with a variations of name.
 * .. compare the actual response value with an expected value and document the result.

The gif shows a sample JUnit test execution in Visual Studio Code of my OpenLiberty project:

![junit-on-openliberty-run-test](images/junit-on-openliberty-run-test.gif)

**Questions are how to**
 
 1. .. setup a JUnit test for the development mode of the OpenLiberty  server
 2. .. convert JSON Data from a String to an Author Java instance with JSON-B
 4. .. define a REST Client?
 5. .. configure parameterized a JUnit test?
 6. .. write the concrete parameterized JUnit test?
 7. .. execute the JUnit test find results test results?

**What are the tools and frameworks?**

That are the Tools and frameworks I use in my example project:

* IDE: [Visual Studio Code](https://code.visualstudio.com/) with the Java Development Extension
* Server: [Open Liberty](https://openliberty.io/)
* Framework: [Eclipse MicroProfile](https://projects.eclipse.org/projects/technology.microprofile)
* Java project organization: [Apache Maven](https://maven.apache.org/)

---

# Additional resources blog posts, videos or manuals

## MicroProfile RestClient

* [Overview MicroProfile REST Client (Tomitribe)](https://www.tomitribe.com/blog/overview-of-microprofile-rest-client/)

## JUnit

* [Setup Unit Tests in OpenLiberty](https://github.com/OpenLiberty/open-liberty/wiki/Unit-Tests)
* [JUnit User Guide dependencies](https://junit.org/junit5/docs/5.1.0-M1/user-guide/#dependency-diagram)
* [Using microprofile rest client for system testing (Adam-Bien)](http://www.adam-bien.com/roller/abien/entry/using_microprofile_rest_client_for)
* [Unit 5 tutorial Writing parameterized tests (Petri Kainulainen)](https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/)
* [Create effective tests or create excuses — testing the Java EE way (Sebastian Daschner)](https://www.youtube.com/watch?v=JPctzdfxeXo)
* [JUnit user-guide running tests is vscode](https://junit.org/junit5/docs/current/user-guide/#running-tests-ide-vscode)

## Jsonb

* [What is JSON binding with JSON-B (RIECKPIL)](https://rieckpil.de/whatis-json-binding-json-b/)
* [3 ways to convert String to JSON object in Java?](https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html)