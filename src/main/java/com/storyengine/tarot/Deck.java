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
    private List<Card> DeckList;
    private Random rand;
    
    public Deck(String deckInput, String jsonHeader) {
        // Create the deck
        DeckList = new ArrayList<>();
        rand = new Random();
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
                DeckList.add(newCard);
            }
        } catch (Exception e) {
            logger.info("We received the following error:\n{}\n", e.toString());
            e.printStackTrace();
        }
    }

    public Integer getDeckSize() {
        return DeckList.size();
    }
    
    public void drawRandomCard() {
        logger.info("Drawing a card from the deck...\n");
        int pick = rand.nextInt(DeckList.size());
        logger.info("You chose card number {}, which happens to be...\n", pick);
        DeckList.get(pick).display();
    }

    public void drawOneFromTop() {
        logger.info("Drawing the top card...\n");
        DeckList.get(0).display();
    }

    public void drawSpecifiedCard(Integer pick) {
        logger.info("Drawing card {} from the deck...\n", pick);
        DeckList.get(pick).display();
    }

    public void shuffle() {
        logger.info("Shuffling the deck...\n");
        Collections.shuffle(DeckList);
    }

    public void shuffleNTimes(Integer numTimes) {
        logger.info("Shuffling the deck {} times...\n", numTimes);
        for (int i = 0; i < numTimes; i++) {
            shuffle();
        }
    }

    public void reorder() {
        logger.info("Reordering the deck...\n");
        Collections.sort(DeckList);
    }
}
