package com.storyengine;

import com.storyengine.tarot.*;
import com.storyengine.narrative.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {
    protected final Config properties = new Config(System.getProperty("prop.file", "src/main/resources/config.properties"));
    private final Logger logger = LoggerFactory.getLogger(Base.class);

    public static void main(String [] args) throws Exception {
        Base bae = new Base();
        bae.logger.info("Welcome to Story Engine, also known as Arcanum!");
    }

    public void setup() throws Exception {
        // Set up all framework pieces here
    }

    public void teardown() throws Exception {
        // Tear down all framework pieces here
    }
}
