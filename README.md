# Arcanum
## Context
Welcome to Arcanum, also known as Story Engine!

## Objective
We use the game of French Tarot to drive stories, since Tarot Cards represent narrative archetypes.

## Rider Waite Tarot Deck
https://tarotx.net/tarot-card-meanings/rider-waite/

Tarot Suit Rankings:
wands (clubs) < cups (hearts) < swords (spades) < pentacles (diamonds)

## French Tarot Game
### Game Setup:
- For three players, there are 24 rounds of play, six card dog, three card packet
- For four players, there are 18 rounds of play, six card dog, three card packet
- For five players, there are 15 rounds of play, three card dog, three card packet
- Shuffle the deck, and deal each player a card. The player with the lowest value card deals first.

### Tarot Gameplay Rules:
We use the following rules as defined in the rules of the game of French Tarot:

0. Tarot Game is a three to five player game, no more, no less.
1. Order all cards (1 - 78).
2. Separate Major Arcana from Minor Arcana.
3. Shuffle all Minor Arcana together, 1st half in right hand reversed, 2nd half upright, both sides face down.
4. Deal all Minor Arcana cards out to all players.
- Always deal cards vertical to each player.
5. Shuffle all Major Arcana together, 1st half in right hand reversed, 2nd hand upright, both sides face down.
6. Deal all Major Arcana cards out to all players.
- Always deal cards vertical to each player.
7. Each player shuffles all Arcana cards together, maintaining dealt orientation.
8. Each player places their shuffled deck to their right-hand side.
9. Each player draws seven cards, pulling card off deck toward themselves.
- The side your hand touches in the draw is the top side.
- Maintain orientation of cards in your hand at all times.
10. Each player agrees on who goes first.
- We say the player who won first deal plays the first trick of the game.
- The first player plays any card from their hand, top side facing away from you.
- Play continues to the left, until all cards have been played.
11. Play happens as follows:
- All cards in Tarot have supports and oppositions.
- That list of details can be found at: https://tarotx.net/tarot-card-meanings/rider-waite/
- After the first card is played, a player has two real options.
- First, play a card that either supports or is supported by the previous card, in any face up square orientation you choose.
- Second, play a card that either opposes or is opposed by the previous card, in any face up square orientation you choose.
- Play continues until the last card is played.
- The result of the last card is the result of the game.
- No objections can be made to the result of the game UNLESS a player has broken any of the above rules.

### Tarot Strategies:
The Taker has one of two decisions to make before game starts:
- They put their lowest face cards into their discard pile, OR, they put their lowest normal cards into their discard pile.
- Both decisions are significant strategy-wise and narrative-wise.
- The default choice made will be discarding the lowest normal cards to the discard pile.

## Narrative Structure
Story can be broken down into basic building blocks:
1. Inciting Incident
2. Complication
3. Crisis
4. Climax
5. Resolution
- We call these questions the "Five Building Block Questions," denoted as FBBQ.

Each layer of story MUST answer these building block questions.
- We define the different layers as follows:
1. Beats (the smallest unit of story)
2. Scenes (basic building blocks of story)
3. Sequences / Chapters (minor life stages in story)
4. Acts (major life stages in story)
5. Subplots (controlling theme amplifiers, useful in long story formats)
6. Global Story (what the author is trying to say)

We have created the following sentence templates:
1. Inciting Incident = Subject (Player) + Upright Verb + Upright Direct Object (Noun)
2. Complication = Subject (Player) + Reversed Verb + Reversed Direct Object (Noun)
3. Crisis = Question Word (D6, What, Where, Why, Who, When, How) + Auxiliary Verb (D7, Be, Do, Can, May, Have, Will, Should) + Subject (Player) + Reversed Verb + ?
4. Climax = Subject (Player) + Upright Verb + Upright Direct Object (Noun)
5. Resolution = Subject (Player) + Upright Verb + Upright Direct Object (Noun) + Conjunctive (D8, For, And, But, Or, Yet, So, However, Therefore) + Subject (Player) + Reversed Verb + Reversed Direct Object (Noun)

To summarize everything we have discussed:
- We can now relate the card interpretations directly to the narrative building blocks using noun extrapolation.
- This is the connection we implement in our algorithm to have a game of French Tarot generate for us a narrative.

## "Arcanum" Algorithm
### Definitions
- Tarot is a 3 - 5 player game, which corresponds to our 3 - 5 card spreads of Tarot cards
- Each player in a game of Tarot corresponds to a defined Character in our story
- Each card played by a player represents "a Scene driven by that player"
- Each Scene answers the FBBQ
- Each Round of Tarot represents a Sequence of 3 - 5 player Scenes, which we call a Chapter
- Each Chapter answers the FBBQ
- The number of Chapters a story has is based on the number of players in a game of Tarot:
1. "for three players, there are 24 rounds of play, six card dog", so 24 Chapters
2. "for four players, there are 18 rounds of play, six card dog", so 18 Chapters
3. "for five players, there are 15 rounds of play, three card dog", so 15 Chapters
- In each of these instances, we add Chapter 0 to account for the Prologue, which determines who plays the first trick of the game
- We assume that every story involves three Acts, following the 25/50/25 novel distribution
- Each Act answers the FBBQ
- We assume that every story involves an amount of Subplot equal to the following:
- -> "Support Characters" are represented by the available face cards in the Tarot deck
- -> If the Trick played is a face card, the Chapter perspective goes to the associated Support Character
- -> The number of rounds this occurs is the total amount of Subplot defined in our story
- Each defined Subplot answers the "Five Building Block Questions"
- We finalize our story using the Global Story
- The Global Story answers the FBBQ

### Algorithm Walk-Through
- We start with creating our Tarot Deck, by uploading a JSON containing each card and relevant data
- We then decide how many main Characters are defined in our story, ranging from 3 to 5
- For each Character, we do a Body Reading, which builds our Character using Tarot card meanings
- After each Character is developed, we initiate a game of French Tarot
- We play a game of French Tarot to obtain all the data we need for our story
- -> For the following exercise, we assume a game with 3 Characters, and therefore 24 Rounds of play
- -> The Character who wins first deal in the Prologue plays the first trick of the game
- -> The Character that wins the game is the protagonist of our story
- -> In each Round, the player who wins the current Round wins the Trick of the next Round

- After we play the game, we now build our (as square as possible) Story Matrix with size = number of Rounds + 1
- With the assumption above, we have the following Matrix:
  | 0 | 5 | 10 | 15 | 20 |
  | 1 | 6 | 11 | 16 | 21 |
  | 2 | 7 | 12 | 17 | 22 |
  | 3 | 8 | 13 | 18 | 23 |
  | 4 | 9 | 14 | 19 | 24 |
- With the Matrix defined, we define the Global Story by using the diagonal of the Matrix, giving us concrete bounds on our narrative structure:
0. Prologue = Global Story Inciting Incident
1. Act 1 AND Global Story Complication
2. Act 2 AND Global Story Crisis
3. Act 2 AND Global Story Climax
4. Act 3 AND Global Story Resolution
- Based on the Tarot Rounds, we need to determine "where and when" each Subplot occurs
- -> Refer to the "Trick is Face Card" definition given above
- -> The Round these events happen is where we define our Subplot in our Matrix
- -> Subplots CAN overlap with the diagonal of our Matrix
- With the Global Story and Subplots established, we fill in Act information between our Global Story concrete bounds:
- -> Ch. 0 = Prologue, Ch. 1 - 6 = Act 1, Ch. 7 - 18 = Act 2, Ch. 19 - 24 = Act 3
- With our (as square as possible) Matrix, we assign Act lengths following the 25/50/25 novel distribution
- -> We now answer the FBBQ within each Act, assigning each question to a Chapter
- -> The questions for each Act CANNOT overlap with the diagonal of our Matrix
- -> Following the 25/50/25 novel distribution, we need two Chapters per question in Act 2, which is twice that of Acts 1 and 3
- We are now ready to evaluate each Sequence/Chapter, which we equate to one Round of French Tarot
- For each Round, we answer the FBBQ based on turn order in the Round:
- -> Player 1 = The Trick = Inciting Incident + Complication
- -> Player 2 = The Defense (Part 1) = Crisis + Climax
- -> Player 3 = The Defense (Part 2) = Resolution
- -> Round Winner = Controls the next Round's Inciting Incident
- -> The above ties together each consecutive Sequence/Chapter through Resolution -> Inciting Incident, looping on our building block narrative structure
- We now evaluate each Scene within each Chapter, where Scene = Card played in Round
- -> Each Card must answer the FBBQ  from the perspective of the Character that played the Card
- We do NOT define Beats, as to give our output enough flexibility in finalizing the writing of our story

We have now answered all building block questions for all our defined layers of story
- We now generate our Rough Draft Output using our Matrix dataset, containing card interpretations and game round results
- We use our noun extrapolation rules defined above to answer each set of FBBQ at each level
- These questions are the sentences we use to fill in each level of our story
- After filling in each section, we return the resulting collection of sentences

## Installation / Usage
Run the following command in terminal inside the project: `mvn -X -U clean test`

## Resources
https://tarotx.net/
https://en.wikipedia.org/wiki/French_Tarot
https://storygrid.com/how-to-learn-writing/