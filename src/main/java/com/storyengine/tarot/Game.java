package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    private final Logger logger = LoggerFactory.getLogger(Game.class);
    private Integer numPlayers;
    private Integer numRounds;
    private Integer dogPile;

    public Game(Integer numPlayers, Integer numRounds, Integer dogPile) {
        this.numPlayers = numPlayers;
        this.numRounds = numRounds;
        this.dogPile = dogPile;

        // TODO: finish setting up tarot game and return game object ready to play from Round 0
    }

    // TODO: Outline game of tarot here, all steps should become functions
}
