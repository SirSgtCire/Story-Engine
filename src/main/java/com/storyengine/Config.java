package com.storyengine;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Config {
    private Properties configFile;

    // Load in the properties file
    public Config(String propertiesFile) {
        configFile = new Properties();

        try {
            FileInputStream input = new FileInputStream(new File(propertiesFile));
            configFile.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch(IOException ioex) {
            throw new IllegalStateException("Error reading config file:\n", ioex);
        }
    }

    // Obtain specified property from properties object
    public String getProperty(String key) { return this.configFile.getProperty(key); }
}
