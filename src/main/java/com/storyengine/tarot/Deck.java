package com.storyengine.tarot;

import java.util.*;
import org.slf4j.Logger;
import java.io.FileReader;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Deck {
    private final Logger logger = LoggerFactory.getLogger(Deck.class);
    private List<Card> Deck;
    private Integer size;
    private Random rand;
    
    public Deck(String deckInput, String jsonHeader) {
        // Create the deck
        Deck = new ArrayList<>();
        rand = new Random();
        Integer cardCount = 0;

        try {
            // Load our deckInput into a jsonObject
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(deckInput));
            JSONArray jsonData = (JSONArray) jsonObject.get(jsonHeader);

            // For each card provided, insert it into our deck
            for (Object obj: jsonData) {
                JSONObject cardData = (JSONObject) obj;
                Card newCard = new Card(
                        cardData.get("title").toString(),
                        cardData.get("image").toString(),
                        cardData.get("arcana").toString(),
                        Integer.parseInt(cardData.get("number").toString()),
                        Integer.parseInt(cardData.get("value").toString()),
                        cardData.get("suit").toString(),
                        cardData.get("rotation").toString(),
                        (JSONObject) cardData.get("keywords")
                );
                Deck.add(newCard);
                cardCount += 1;
            }
            size = cardCount;

        } catch (Exception e) {
            logger.info(String.format("We received the following error:\n%s\n", e));
            e.printStackTrace();
        }
    }

    public Integer getNumCards() {
        return this.size;
    }
    
    public void randomCard(Integer deckSize) {
        logger.info("Drawing a card from the deck...\n");
        int pick = rand.nextInt(deckSize);
        logger.info(String.format("You chose card number %d, which happens to be...\n", pick));
        Deck.get(pick).display();
    }

    public void shuffle() {
        logger.info("Shuffling the deck...\n");
        Collections.shuffle(Deck);
    }

    public void reorder() {
        logger.info("Reordering the deck...\n");
        Collections.sort(Deck);
    }

    public void drawOneFromTop() {
        logger.info("Drawing the top card...\n");
        Deck.get(0).display();
    }

    public void rotate(Card c) {
        String oldRotation = c.rotation;
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
        c.rotation = newRotation;
        logger.info(String.format("Latest rotation: %s\n", c.rotation));
    }
}
