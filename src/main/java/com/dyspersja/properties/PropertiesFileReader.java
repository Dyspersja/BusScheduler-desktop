package com.dyspersja.properties;

import java.util.Properties;

public class PropertiesFileReader {
    private final String defaultPropertiesFilePath = "application.properties";
    private final String resourcesPropertiesFilePath = "src/main/resources/application.properties";

    private final Properties properties;

    public PropertiesFileReader() {
        properties = new Properties();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
