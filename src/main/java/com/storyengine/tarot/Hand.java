package com.storyengine.tarot;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hand {
    private final Logger logger = LoggerFactory.getLogger(Hand.class);
    private Integer maximumHandSize;
    private List<Card> cardsInHand;
    private String player;

    public Hand(Integer maxSize, List<Card> cards, String player) {
        this.maximumHandSize = maxSize;
        this.cardsInHand = cards;
        this.player = player;
    }

    public void drawCard(Card c) {
        if (cardsInHand.size() < maximumHandSize) {
            cardsInHand.add(c);
        }
    }

    public void drawNCards(Integer numTimes, List<Card> cards) {
        logger.info("Drawing {} cards from the deck...\n", numTimes);
        for (int i = 0; i < numTimes; i++) {
            drawCard(cards.get(i));
        }
    }

    public void discardCard(Card c) {
        if (cardsInHand.size() > 0) {
            cardsInHand.remove(c);
        }
    }

    public void discardNCards(Integer numTimes, List<Card> cards) {
        logger.info("Discarding {} cards from the hand...\n", numTimes);
        for (int i = 0; i < numTimes; i++) {
            discardCard(cards.get(i));
        }
    }
}
