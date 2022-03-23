package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONObject;

public class Card implements Comparable<Card> {
    private static final Logger logger = LoggerFactory.getLogger(Card.class);
    private String title;
    private String image;
    private String arcana;
    private Integer number;
    private Integer value;
    private String suit;
    private String rotation;
    private JSONObject keywords;
    private enum rotations {
        REVERSED, UPRIGHT;
    }
    
    public Card(String title, String image, String arcana, Integer number,
                Integer value, String suit, String rotation, JSONObject keywords) {
        this.title = title;
        this.image = image;
        this.arcana = arcana;
        this.number = number;
        this.value = value;
        this.suit = suit;
        this.rotation = rotation;
        this.keywords = keywords;
    }

    // Helper method for sorting cards back to their starting state in a Deck
    @Override
    public int compareTo(Card c) {
        if (this.number == null || c.number == null) {
            return 0;
        }
        return this.number.compareTo(c.number);
    }

    public void display() {
        logger.info(String.format("Card: %s\n", title));
        logger.info(String.format("Image: %s\n", image));
        logger.info(String.format("Arcana: %s\n", arcana));
        logger.info(String.format("Number: %d\n", number));
        logger.info(String.format("Value: %d\n", value));
        logger.info(String.format("Suit: %s\n", suit));
        logger.info(String.format("Rotation: %s\n", rotation));
        logger.info(String.format("Keywords: %s\n", keywords.toString()));
    }

    public void rotate(String newRotation) {
        logger.info(String.format("Old rotation: %s\n", rotation));
        try {
            this.rotation = rotations.valueOf(newRotation).toString();
        } catch (Exception e) {
            logger.error(String.format("We received the following input, %s, which triggered the following error:\n%s\n", newRotation, e));
            throw e;
        }
        logger.info(String.format("New rotation: %s\n", rotation));
    }
}
