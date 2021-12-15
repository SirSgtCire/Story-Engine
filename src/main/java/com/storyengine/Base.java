package com.storyengine;

public class Base {
    protected static final Config properties = new Config(System.getProperty("prop.file"));
    protected static final Logger logger = LoggerFactory.getLogger(Base.class);
    
}
