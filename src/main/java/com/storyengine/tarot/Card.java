package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONObject;

public class Card implements Comparable<Card> {
    private final Logger logger = LoggerFactory.getLogger(Card.class);
    private String title;
    private String image;
    private String arcana;
    private Integer number;
    private Integer value;
    private String suit;
    protected String rotation;
    private JSONObject keywords;
    
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

    public void rotate() {
        String oldRotation = this.rotation;
        String newRotation = "UPRIGHT";
        logger.info(String.format("Current rotation: %s\n", oldRotation));
        switch (oldRotation) {
            case "UPRIGHT":
                logger.info("Rotation is now REVERSED\n");
                newRotation = "REVERSED";
                break;
            case "REVERSED":
                logger.info("Rotation is now UPRIGHT\n");
                newRotation = "UPRIGHT";
                break;
            default:
                logger.info("Rotation has not changed\n");
                break;
        }
        this.rotation = newRotation;
        logger.info(String.format("Latest rotation: %s\n", this.rotation));
    }
}
