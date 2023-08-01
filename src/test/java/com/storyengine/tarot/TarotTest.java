package com.storyengine.tarot;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.storyengine.Base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Tests using Tarot to play the game of French Tarot
 */
public class TarotTest extends Base {
    private final Logger logger = LoggerFactory.getLogger(TarotTest.class);

    @BeforeTest
    public void testInit() throws Exception {
        super.setup();
    }

    @AfterTest
    public void testTerm() throws Exception {
        super.teardown();
    }

    @Test
    public void testGameOfTarot() throws Exception {
        logger.info("Starting a new game of French Tarot...\n");

        // TODO: Run a game of tarot and verify each step succeeds
        int x = 5;
        int y = 5;
        Assert.assertEquals(x, y, "This should not fail unless changed.");
    }
}
