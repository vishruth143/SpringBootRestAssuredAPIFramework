package com.ea.SpringBootSeleniumFramework.steps;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CucumberTestContextConfig.class)
public class Hooks {
    @Value("${base.uri}")
    private String baseUri;

    @Value("${x.api.key}")
    private String apiKey;

    public static RequestSpecification requestSpec;

    @Before
    public void setup() {
        System.out.println("Hooks->setup");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .addHeader("x-api-key", apiKey)
                .setContentType("application/json")
                .build();
    }
}
