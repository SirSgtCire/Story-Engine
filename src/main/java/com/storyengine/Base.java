package com.storyengine;

import com.storyengine.tarot.*;
import com.storyengine.narrative.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {
    protected final Config properties = new Config(System.getProperty("prop.file", "src/main/resources/config.properties"));
    protected Deck tarotDeck;
    protected Game tarotGame;
    protected Spread tarotSpread;
    private final Logger logger = LoggerFactory.getLogger(Base.class);

    public void setup(Integer sizeOfGame) throws Exception {
        // Set up all framework pieces here
        logger.info("Initializing Story Engine...");
        tarotDeck = new Deck(
                properties.getProperty("json.card.input"),
                properties.getProperty("json.card.header"));
        switch (sizeOfGame) {
            case 3:
                tarotGame = new Game(
                        tarotDeck,
                        Integer.parseInt(properties.getProperty("three.players")),
                        Integer.parseInt(properties.getProperty("three.rounds")),
                        Integer.parseInt(properties.getProperty("three.dog.pile")),
                        Integer.parseInt(properties.getProperty("three.packet.size")));
            case 4:
                tarotGame = new Game(
                        tarotDeck,
                        Integer.parseInt(properties.getProperty("four.players")),
                        Integer.parseInt(properties.getProperty("four.rounds")),
                        Integer.parseInt(properties.getProperty("four.dog.pile")),
                        Integer.parseInt(properties.getProperty("four.packet.size")));
            case 5:
                tarotGame = new Game(
                        tarotDeck,
                        Integer.parseInt(properties.getProperty("five.players")),
                        Integer.parseInt(properties.getProperty("five.rounds")),
                        Integer.parseInt(properties.getProperty("five.dog.pile")),
                        Integer.parseInt(properties.getProperty("five.packet.size")));
        }
        tarotSpread = new Spread(tarotDeck);
    }

    public void teardown() throws Exception {
        // Tear down all framework pieces here
        logger.info("Terminating Story Engine...");
    }
}
