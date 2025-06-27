package com.ea.SpringBootSeleniumFramework.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static com.ea.SpringBootSeleniumFramework.steps.Hooks.requestSpec;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ContextConfiguration
public class UserAPISteps {

    private static final String API_KEY = "reqres-free-v1";

    @Value("${base.uri}")
    private String baseUri;

    private Response response;

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        response = RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(endpoint);
    }

    @When("I send a POST request to {string} with body:")
    public void iSendAPOSTRequestToWithBody(String endpoint, String body) {
        response = RestAssured
                .given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertThat(response.getStatusCode(), is(expectedStatusCode));
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContain(String expectedText) {
        assertThat(response.getBody().asString(), containsString(expectedText));
    }
}
