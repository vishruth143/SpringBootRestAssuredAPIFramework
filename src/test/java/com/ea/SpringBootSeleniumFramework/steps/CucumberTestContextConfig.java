package com.ea.SpringBootSeleniumFramework.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest
//@ActiveProfiles("prod")
public class CucumberTestContextConfig {
}
