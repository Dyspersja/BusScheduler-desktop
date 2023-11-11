package com.dyspersja.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesFileReader {

    private final String propertiesFileName = "config.properties";

    private final Properties properties;

    public PropertiesFileReader() {
        properties = new Properties();
        loadProperties();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void loadProperties() {
        try {
            loadDefaultProperties();
            if (doesExternalPropertiesFileExist())
                loadFromExternalPropertiesFile();
            else createExternalPropertiesFile();
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties from file");
        }
    }

    private void loadDefaultProperties() throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFileName)) {
            properties.load(input);
        }
    }

    private boolean doesExternalPropertiesFileExist() {
        File propertiesFile = new File(propertiesFileName);
        return propertiesFile.exists() && propertiesFile.isFile();
    }

    private void loadFromExternalPropertiesFile() throws IOException {
        try (var fis = new FileInputStream(propertiesFileName)) {
            properties.load(fis);
        }
    }

    private void createExternalPropertiesFile() throws IOException {
        try (OutputStream output = new FileOutputStream(propertiesFileName)) {
            properties.store(output,"Default configuration file");
        }
    }
}
