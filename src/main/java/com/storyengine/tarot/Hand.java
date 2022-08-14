package com.storyengine.tarot;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hand {
    private final Logger logger = LoggerFactory.getLogger(Hand.class);
    private Integer startingHandSize;
    private Integer maximumHandSize;
    private List<Card> cardsInHand;
    private String player;

    public Hand(Integer startSize, Integer maxSize, List<Card> cards, String player) {
        this.startingHandSize = startSize;
        this.maximumHandSize = maxSize;
        this.cardsInHand = cards;
        this.player = player;
    }

    public void drawTopCard() {

    }

    public void drawNCards() {

    }

    public void discardCard() {

    }
}
