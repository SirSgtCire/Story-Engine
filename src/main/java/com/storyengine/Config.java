package com.storyengine;

import java.io.File;
import org.slf4j.Logger;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Config {
    private final Logger logger = LoggerFactory.getLogger(Config.class);
    private Properties configFile;

    // Load in the properties file
    public Config(String propertiesFile) {
        configFile = new Properties();

        try {
            FileInputStream input = new FileInputStream(new File(propertiesFile));
            configFile.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch(IOException ioex) {
            logger.error("Error reading config file:\n"+ioex.getLocalizedMessage());
            throw new IllegalStateException("Error reading config file:\n", ioex);
        }
    }

    // Obtain specified property from properties object
    public String getProperty(String key) { return this.configFile.getProperty(key); }
}
