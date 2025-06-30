package com.ea.SpringBootRestAssuredAPIFramework.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RetryFailedTestCases implements IRetryAnalyzer {

    private static final int maxRetryCount = 2;
    private static final Map<String, Integer> retryAttempts = new ConcurrentHashMap<>();
    private static final ThreadLocal<String> currentScenarioName = new ThreadLocal<>();

    public static void setCurrentScenarioName(String scenarioName) {
        currentScenarioName.set(scenarioName);
    }

    @Override
    public boolean retry(ITestResult result) {
        String scenarioName = currentScenarioName.get();
        int currentCount = retryAttempts.getOrDefault(scenarioName, 0);

        if (currentCount < maxRetryCount) {
            currentCount++;
            retryAttempts.put(scenarioName, currentCount);
            System.out.println("-".repeat(200));
            System.out.printf("→ Retry Attempt %d for scenario: %s %n", currentCount, scenarioName);
            return true;
        }
        return false;
    }

    public static int getRetryCount(String scenarioName) {
        return retryAttempts.getOrDefault(scenarioName, 0);
    }
}
