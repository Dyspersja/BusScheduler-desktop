package com.dyspersja.properties;

public class PropertiesLoader {

    private static PropertiesLoader instance;

    private final PropertiesArgumentParser argumentParser;
    private final PropertiesFileReader fileReader;

    private PropertiesLoader(String[] args) {
        this.argumentParser = new PropertiesArgumentParser(args);
        this.fileReader = new PropertiesFileReader();
    }

    public static PropertiesLoader getInstance() {
        if (instance == null)
            throw new IllegalStateException("PropertiesLoader has not been initialized");

        return instance;
    }

    public static void createInstance(String[] args) {
        if (instance != null)
            throw new IllegalStateException("PropertiesLoader has already been initialized");

        instance = new PropertiesLoader(args);
    }

    public String getDatabaseUrl() {
        String fileUrl = fileReader.getProperty("database.url");
        String argsUrl = argumentParser.getUrl();

        return argsUrl != null ? argsUrl : fileUrl;
    }

    public String getDatabaseUsername() {
        String fileUsername = fileReader.getProperty("database.username");
        String argsUsername = argumentParser.getUsername();

        return argsUsername != null ? argsUsername : fileUsername;
    }

    public String getDatabasePassword() {
        String filePassword = fileReader.getProperty("database.password");
        String argsPassword = argumentParser.getPassword();

        return argsPassword != null ? argsPassword : filePassword;
    }
}
