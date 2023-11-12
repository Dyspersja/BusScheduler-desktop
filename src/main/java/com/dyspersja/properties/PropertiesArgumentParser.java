package com.dyspersja.properties;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import lombok.Getter;

@Getter
public class PropertiesArgumentParser {

    @Parameter(names = "--url", description = "Database URL")
    private String url;
    @Parameter(names = {"--username", "-u"}, description = "Database username")
    private String username;
    @Parameter(names = {"--password", "-p"}, description = "Database password")
    private String password;

    public PropertiesArgumentParser(String[] args) {
        JCommander.newBuilder()
                .addObject(this)
                .build()
                .parse(args);
    }
}
