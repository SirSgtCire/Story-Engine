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
    private Integer size;
    private Random rand;
    
    public Deck(String deckInput, String jsonHeader) throws Exception {
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
                JSONObject card = (JSONObject) obj;
                JSONObject cardData = (JSONObject) card.get(String.format("%s", jsonData.indexOf(card)));
                Card newCard = new Card(
                        jsonData.indexOf(card),
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
    }

    public void drawOneFromTop() {
        logger.info("Drawing the top card...\n");
    }
}
