package com.storyengine.tarot;

import org.slf4j.Logger;
import java.util.Scanner;
import org.slf4j.LoggerFactory;

public class Spread {
    private static final Logger logger = LoggerFactory.getLogger(Spread.class);

    public static void FortuneTeller() {
        Deck tarotDeck = new Deck();
        Scanner input = new Scanner(System.in);
        logger.info("Welcome, welcome...");
        //ask if the user wants a reading or story prompts
        logger.info("Enter R for a reading or S for story prompts:");
        String response = input.nextLine();
        switch (response) {
            case "R":
            case "r":
                int nextCard = 1;
                int numCards = 1;
                while (nextCard == 1) {
                    logger.info("Please think of a question you would like to have answered:");
                    //on repeats it's not waiting for this and idk why......
                    input.nextLine();
                    logger.info("How many cards shall I pull for you?");
                    numCards = input.nextInt();
                    for (int k = 0; k < numCards; k++) {
                        logger.info("Drawing card "+(k+1)+" of "+(numCards+1));
                        tarotDeck.randomCard(78);
                    }
                    logger.info("Hmm, interesting....");
                    logger.info("Another question? (1 for yes, 2 for no)");
                    //technically anything other than 1 is a no but......
                    nextCard = input.nextInt();
                    input.nextLine();
                    //Should validate that it's an int, but that's a job for later.  For now we /trust/.
                }
                break;
            case "S":
            case "s":
                int next = -1;
                String story = "";
                logger.info("Here's your starting prompt:");

                while (next != 0) {
                    tarotDeck.randomCard();
                    story += (input.nextLine() + "\n");
                    do {
                        logger.info("Enter 1 for another prompt or 0 to end.");
                        next = input.nextInt();
                        input.nextLine();
                    } while ((next != 1) && (next != 0));
                    if (next == 0) {
                        logger.info("Thanks for playing!  Here's your final story:");
                        logger.info(story);
                    }
                }
                break;
            default:
                logger.info("You're not great at following simple directions, are you?");
        }
        input.close();
        logger.info("Until next time...");
    }

    public static void NCardReading(Integer cardCount) {

    }

    public static void BodyReading() {

    }

    public static void BeatReading() {

    }
}
