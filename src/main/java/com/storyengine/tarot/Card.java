package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONObject;

public class Card {
    private static final Logger logger = LoggerFactory.getLogger(Card.class);
    private Integer order;
    private String title;
    private String image;
    private String arcana;
    private Integer number;
    private Integer value;
    private String suit;
    private String rotation;
    private JSONObject keywords;
    private JSONObject cardinality;
    private enum rotations {
        REVERSED, LONSIDE, RONSIDE, UPRIGHT;
    }
    
    public Card(Integer order, String title, String image, String arcana, Integer number,
                Integer value, String suit, String rotation, JSONObject keywords) {
        this.order = order;
        this.title = title;
        this.image = image;
        this.arcana = arcana;
        this.number = number;
        this.value = value;
        this.suit = suit;
        this.rotation = rotation;
        this.keywords = keywords;
    }

    public void display() {
        logger.info(String.format("Order in Deck: %d\n", order));
        logger.info(String.format("Card: %s\n", title));
        logger.info(String.format("Image: %s\n", image));
        logger.info(String.format("Arcana: %s\n", arcana));
        logger.info(String.format("Number: %d\n", number));
        logger.info(String.format("Value: %d\n", value));
        logger.info(String.format("Suit: %s\n", suit));
        logger.info(String.format("Rotation: %s\n", rotation));
        logger.info(String.format("Keywords: %s\n", keywords.toString()));
        logger.info(String.format("Cardinality: %s\n", cardinality.toString()));
    }

    public void rotate(String newRotation) {
        logger.info(String.format("Old rotation: %s\n", rotation));
        try {
            this.rotation = rotations.valueOf(newRotation).toString();
        } catch (Exception e) {
            logger.error(String.format(
                    "We received the following input, %s, and received the following error:\n%s\n", newRotation, e));
        }
        logger.info(String.format("New rotation: %s\n", rotation));
    }

    public void placement(Integer roll) {
        switch (roll) {
            case 1:
                cardinality = null;
                cardinality.put(1,"SOUTH,REVERSED");
                break;
            case 2:
                cardinality = null;
                cardinality.put(2,"WEST,LONSIDE");
                break;
            case 3:
                cardinality = null;
                cardinality.put(3,"EAST,RONSIDE");
                break;
            case 4:
                cardinality = null;
                cardinality.put(4,"NORTH,UPRIGHT");
                break;
            default:
                logger.info(String.format("Roll %d does NOT use a d4, please roll again...\n", roll));
        }
    }
}
