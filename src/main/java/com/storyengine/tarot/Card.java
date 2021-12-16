package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Card {
    private static final Logger logger = LoggerFactory.getLogger(Card.class);
    private String title;
    private String keywords;
    
    public Card(String title, String keywords) {
        this.title = title;
        this.keywords = keywords;
    }

    public void display() {
        logger.info("Card: " + title);
        logger.info("Keywords: " + keywords);
    }
}
