package com.storyengine;

import com.storyengine.tarot.*;
import com.storyengine.narrative.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class Base {
    protected final Config properties = new Config(System.getProperty("prop.file", "src/main/resources/config.properties"));
    private final Logger logger = LoggerFactory.getLogger(Base.class);

    public void main(String [] args) throws Exception {
        logger.info("Welcome to Story Engine!");
    }
}
