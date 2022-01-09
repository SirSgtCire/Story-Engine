package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Card {
    private static final Logger logger = LoggerFactory.getLogger(Card.class);
    private String title;
    private String image;
    private String arcana;
    private Integer number;
    private String suit;
    private String rotation;
    private String keywords;
    private enum rotations {
        UPRIGHT, RONSIDE, LONSIDE, REVERSED, FACEDOWN
    }
    
    public Card(String title, String image, String arcana, Integer number, String suit, String rotation, String keywords) {
        this.title = title;
        this.image = image;
        this.arcana = arcana;
        this.number = number;
        this.suit = suit;
        this.rotation = rotation;
        this.keywords = keywords;
    }

    public void display() {
        logger.info("Card: " + title);
        logger.info("Image: " + image);
        logger.info("Arcana: " + arcana);
        logger.info("Number: " + number);
        logger.info("Suit: " + suit);
        logger.info("Rotation: " + rotation);
        logger.info("Keywords: " + keywords);
    }

    public void rotate(String newRotation) {
        logger.info("Old rotation: " + rotation);
        //TODO: use enums to change rotations
        this.rotation = newRotation;
        logger.info("New rotation: " + rotation);
    }
}
