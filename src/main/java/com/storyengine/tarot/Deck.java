package com.storyengine.tarot;

import java.util.*;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deck {
    private static final Logger logger = LoggerFactory.getLogger(Deck.class);
    private List<Card> Deck;
    private Random rand;
    private Card card;
    
    Deck(String deckInput, String jsonHeader) throws Exception {
        // Create the deck
        Deck = new ArrayList<>();
        rand = new Random();

        try {
            // Load our deckInput into a jsonObject
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(deckInput));
            JSONArray jsonData = (JSONArray) jsonObject.get(jsonHeader);
            Iterator<Card> iterator = jsonData.iterator();

            // For each card provided, insert it into our deck
            while(iterator.hasNext()) {
                //TODO: print each aspect of the card, to make sure we can assign each to the card object
            }

        } catch (Exception e) {
            logger.info("We received an error with deck input: " + e);
            e.printStackTrace();
        }
    }
    
    public void randomCard(Integer deckSize) {
        logger.info("Drawing a card from the deck...");
        int pick = rand.nextInt(deckSize);
        card = Deck.get(pick);
        card.display();
    }

    public void shuffle() {
        logger.info("Shuffling the deck...");
        Collections.shuffle(Deck);
    }

    public void drawOneFromTop() {
        logger.info("Drawing the top card...");
    }
}
