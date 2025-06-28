package com.ea.SpringBootRestAssuredAPIFramework.steps;

import com.ea.SpringBootRestAssuredAPIFramework.util.ConfigParser;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static com.ea.SpringBootRestAssuredAPIFramework.steps.Hooks.requestSpec;
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

    @When("I send a POST request to {string} using payload for {string}")
    public void iSendAPOSTRequestToUsingPayloadFor(String endpoint, String scenarioName) {
        JsonNode payload = ConfigParser.loadJson("api_test_data_config").get(scenarioName);

        if (payload == null) {
            throw new RuntimeException("Payload not found for scenario: " + scenarioName);
        }

        response = RestAssured
                .given()
                .spec(requestSpec)
                .body(payload.toString())
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
