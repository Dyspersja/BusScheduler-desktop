package com.dyspersja;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class PropertyManager {

    @Parameter(names = "-url", description = "Database URL")
    private String url;
    @Parameter(names = "-username", description = "Database username")
    private String username;
    @Parameter(names = "-password", description = "Database password")
    private String password;

    public PropertyManager(String[] args) {
        JCommander.newBuilder()
                .addObject(this)
                .build()
                .parse(args);
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
