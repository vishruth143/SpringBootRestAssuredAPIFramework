package com.ea.SpringBootRestAssuredAPIFramework.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser {

    private static final Map<String, String> CONFIG_FILE_PATHS = new HashMap<>();

    static {
        CONFIG_FILE_PATHS.put("api_test_data_config", "src/test/resources/config/payload.json");
    }

    public static JsonNode loadJson(String configName) {
        try {
            File file = Paths.get(CONFIG_FILE_PATHS.get(configName)).toFile();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(file);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON: " + configName, e);
        }
    }
}