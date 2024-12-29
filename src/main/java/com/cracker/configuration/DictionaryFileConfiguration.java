package com.cracker.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@ConfigurationProperties(prefix="dictionary.file")
public class DictionaryFileConfiguration {
    private String path ;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
