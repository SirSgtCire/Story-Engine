package com.storyengine;

import com.storyengine.tarot.*;
import com.storyengine.narrative.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {
    protected final Config properties = new Config(System.getProperty("prop.file", "src/main/resources/config.properties"));
    protected Deck tarotDeck;
    protected Game tarotGame;
    private final Logger logger = LoggerFactory.getLogger(Base.class);

    public void setup() throws Exception {
        // Set up all framework pieces here
        logger.info("Initializing Story Engine...");
        tarotDeck = new Deck(
                properties.getProperty("json.card.input"),
                properties.getProperty("json.card.header"));
        tarotGame = new Game(
                Integer.parseInt(properties.getProperty("num.players")),
                Integer.parseInt(properties.getProperty("num.rounds")),
                Integer.parseInt(properties.getProperty("dog.pile")));
    }

    public void teardown() throws Exception {
        // Tear down all framework pieces here
        logger.info("Terminating Story Engine...");
    }
}
