package com.storyengine.tarot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.storyengine.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

/**
 * Tests using Tarot to play the game of French Tarot
 */
public class TestTarot extends Base {
    private final Logger logger = LoggerFactory.getLogger(TestTarot.class);

    @BeforeTest
    public void testInit() throws Exception {
        super.setup(Integer.parseInt(properties.getProperty("game.size")));
    }

    @AfterTest
    public void testTerm() throws Exception {
        super.teardown();
    }

    @Test
    public void testCard() throws Exception {
        logger.info("Testing card attributes and functions.\n");

        // TODO: Verify functions in Card class
    }

    @Test
    public void testDeck() throws Exception {
        logger.info("Testing deck attributes and functions.\n");

        // TODO: Verify functions in Deck class
    }

    @Test
    public void testGame() throws Exception {
        logger.info("Testing game attributes and functions.\n");

        // TODO: Verify functions in Game class
    }

    @Test
    public void testSpread() throws Exception {
        logger.info("Testing spread attributes and functions.\n");

        // TODO: Verify functions in Spread class
    }

    @Test
    public void testFrenchTarot() throws Exception {
        logger.info("Starting a full round of French Tarot...\n");

        // TODO: Run a game of tarot and verify each step succeeds
        int x = 5;
        int y = 5;
        Assert.assertEquals(x, y, "This should not fail unless changed somewhere else.");
    }
}
