package com.storyengine;

import com.storyengine.tarot.Spread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {
    //protected static final Config properties = new Config(System.getProperty("prop.file"));
    private static final Logger logger = LoggerFactory.getLogger(Base.class);

    public static void main(String [] args) throws Exception {
        logger.info("WE ARE ALIVE!!!");

        Spread.FortuneTeller();

        logger.info("Well done. Go to sleep now my child.");
    }
}
