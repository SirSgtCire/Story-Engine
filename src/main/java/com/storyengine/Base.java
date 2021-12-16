package com.storyengine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {
    protected static final Config properties = new Config(System.getProperty("prop.file"));
    private static final Logger logger = LoggerFactory.getLogger(Base.class);

    public static void main(String [] args) {
        logger.info("WE ARE ALIVE!!!");
    }
}
