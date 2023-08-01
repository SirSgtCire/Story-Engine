package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    private final Logger logger = LoggerFactory.getLogger(Game.class);
    private Deck deckList;
    private Integer numPlayers;
    private Integer numRounds;
    private Integer dogPile;
    private Integer packetSize;

    public Game(Deck deckList, Integer numPlayers, Integer numRounds, Integer dogPile, Integer packetSize) {
        this.deckList = deckList;
        this.numPlayers = numPlayers;
        this.numRounds = numRounds;
        this.dogPile = dogPile;
        this.packetSize = packetSize;

        // TODO: finish setting up tarot game and return game object ready to play from Round 0
        // Start the game
        // Play the game out
        // Review the end-game stats
    }

    // TODO: Outline game of tarot here, all steps should become functions
    // Manages the complex steps for shuffling a Tarot deck, per the rules of French Tarot
    public void TarotGameStart() {
        // Shuffle the deck
        // Each player draws one card -> The lowest value is the "First Dealer"
        // Return all cards to the deck
        // Choose between "Regular Shuffle" or "Special Shuffle" then shuffle
        // Each player draws seven cards
        // Return here
    }

    // Helper function for handling special shuffle rules
    public void SpecialShuffle() {
        // Separate Major and Minor Arcana
        // Take half of Minor Arcana and reverse direction, then shuffle
        // Deal out Minor Arcana to all players
        // Take half of Major Arcana and reverse direction, then shuffle
        // Deal out Major Arcana to all players
        // Each player confirms they have their own deck by shuffling it
        // Return here
    }

    // Helper function for maintaining all variables needed during one round of Tarot
    public void TarotGameRound() {
        // For each given round of Tarot
            // For each player
                // play one card from hand
                // if first, trick -> if second, defense part 1 -> if third, defense part 2
            // rank the played cards from lowest to highest
            // Award Round Winner
        // Award Game Winner
        // Return here
    }
}
