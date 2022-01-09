package com.storyengine.tarot;

import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deck {
    private static final Logger logger = LoggerFactory.getLogger(Deck.class);
    private List<Card> Deck;
    private Random rand;
    private Card card;
    
    Deck(String deckInput) throws ParseException {
        // Create the deck
        Deck = new ArrayList<>();
        rand = new Random();

        // Load our deckInput into a jsonObject
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(deckInput);
        JSONArray jsonData = (JSONArray) jsonObject.get();

        // For each card provided, insert it into our deck



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
