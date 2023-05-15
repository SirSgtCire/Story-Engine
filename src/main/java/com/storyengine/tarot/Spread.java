package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Spread {
    private final Logger logger = LoggerFactory.getLogger(Spread.class);
    private Deck deckList;

    public Spread(Deck deckList) {
        this.deckList = deckList;
    }

    public void NCardReading(Integer cardCount) {
        // TODO: draw cards from the deck equal to card count, then display each in a row in order of draw
    }

    public void BodyReading() {
        // TODO: Perform a body reading for character creation, displaying all cards in proper configuration
    }

    // TODO: Add more spread types as functions below
}
