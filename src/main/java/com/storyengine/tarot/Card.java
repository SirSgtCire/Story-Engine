package com.storyengine.tarot;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Card {
    private static final Logger logger = LoggerFactory.getLogger(Card.class);
    private Integer order;
    private String title;
    private String image;
    private String arcana;
    private Integer number;
    private String suit;
    private String rotation;
    private String keywords;
    private JSONObject legend;
    private enum rotations {
        UPRIGHT, RONSIDE, LONSIDE, REVERSED, FACEDOWN
    }
    private enum compass {
        NORTH, EAST, WEST, SOUTH, CENTER
    }
    
    public Card(Integer order, String title, String image, String arcana, Integer number,
                String suit, String rotation, String keywords, JSONObject legend) {
        this.order = order;
        this.title = title;
        this.image = image;
        this.arcana = arcana;
        this.number = number;
        this.suit = suit;
        this.rotation = rotation;
        this.keywords = keywords;
        this.legend = legend;
    }

    public void display() {
        logger.info("Order in Deck: " + order);
        logger.info("Card: " + title);
        logger.info("Image: " + image);
        logger.info("Arcana: " + arcana);
        logger.info("Number: " + number);
        logger.info("Suit: " + suit);
        logger.info("Rotation: " + rotation);
        logger.info("Keywords: " + keywords);
        logger.info("Legend: " + legend);
    }

    public void rotate(String newRotation) {
        logger.info("Old rotation: " + rotation);
        try {
            this.rotation = rotations.valueOf(newRotation).toString();
        } catch (Exception e) {
            logger.error(String.format("We received the following error:\n%s", e));
            logger.info("Here are the valid inputs that can be used: UPRIGHT, RONSIDE, LONSIDE, REVERSED, FACEDOWN\n");
        }
        logger.info("New rotation: " + rotation);
    }
}
