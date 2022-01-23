# Arcanum
## Context
Welcome to Arcanum!
Also known as Story Engine!

## Objective
We intend to use the game of French Tarot to drive stories, since Tarot Cards represent narrative archetype.

## Rider Waite Tarot Deck
Blah

## French Tarot Game
###Game Setup:
- For three players, there are 24 rounds of play, six card dog
- For four players, there are 18 rounds of play, six card dog
- For five players, there are 15 rounds of play, three card dog

###Tarot Gameplay Rules:
0. Tarot Game is a three to five player game, no more, no less.
1. Order all cards (1 - 78).
2. Separate Major Arcana from Minor Arcana.
3. Shuffle all Minor Arcana together, 1st half in right hand reversed, 2nd half upright, both sides face down.
4. Deal all Minor Arcana cards out to all players
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
- The first player plays any card from their hand, top side facing away from you.
- Play continues to the left, until all cards have been played.
11. Play happens as follows:
- All cards in Tarot have supports and oppositions.
- That list of details can be found at: https://tarotx.net/tarot-card-meanings/rider-waite/
- After the first card is played, a player has two real options.
- First, play a card that either supports or is supported by the previous card, in any faceup square orientation you choose.
- Second, play a card that either opposes or is opposed by the previous card, in any faceup square orientation you choose.
- Play continues until the last card is played.
- The result of the last card is the result of the game.
- No objections can be made to the result of the game UNLESS a player has broken any of the above rules.

###Tarot Strategies:
The Taker has one of two decisions to make before game starts:
- They put their lowest face cards into their discard pile, OR, they put their lowest normal cards into their discard pile.
- Both decisions are significant strategy-wise and narrative-wise.
- The default choice made will be discarding the lowest normal cards to the discard pile.

## Narrative Structure
- Story can be broken down into basic building blocks:
1. Inciting Incident
2. Complication
3. Crisis
4. Climax
5. Resolution
- Each layer of story MUST answer these building block questions:
1. Beats (smallest unit of story)
2. Scenes (basic building blocks of story)
3. Sequences / Chapters (minor life stages in story)
4. Acts (major life stages in story)
5. Subplots (controlling theme amplifiers, useful in long story formats)
6. Global Story (what the author is trying to say)
- We call these questions the "Five Building Block Questions"

## Algorithm
- Tarot is a 3 - 5 player game, which corresponds to our 3 - 5 card spreads of Tarot cards
- Each player in a game of Tarot corresponds to a defined Character in our story
- Each card played by a player represents "a Scene driven by that player"
- Each Scene answers the "Five Building Block Questions"
- Each Round of Tarot represents a Sequence of 3 - 5 player Scenes, which we call a Chapter
- Each Chapter answers the "Five Building Block Questions"
- The number of Chapters a story has is based on the number of players in a game of Tarot:
1. "for three players, there are 24 rounds of play, six card dog", so 24 Chapters
2. "for four players, there are 18 rounds of play, six card dog", so 18 Chapters
3. "for five players, there are 15 rounds of play, three card dog", so 15 Chapters
- In each of these instances, we add Chapter 0 to complete our number of Chapters
- We assume that every story involves three Acts, following the 25/50/25 novel distribution
- Each Act answers the "Five Building Block Questions"
- We assume that every story involves an amount of Subplot equal to the following:
- -> "Support Characters" as defined above are represented by the available face cards
- -> If the Trick played is a face card, the Chapter goes to the associated Support Character
- -> The number of rounds this occurs is the total amount of Subplot defined in our story
- Each defined Subplot answers the "Five Building Block Questions"
- We finalize our story using the Global Story
- The Global Story answers the "Five Building Block Questions"

- We play a game of French Tarot to obtain all the data we need for our story
- -> For the following exercise, we assume a game with 3 Characters, and therefore 24 Rounds of play
- -> The Character that wins the game is the protagonist of our story

- After we play the game, we now build our (as square as possible) Story Matrix with size = number of Rounds
- With the assumption above, we have the following Matrix:
  0 5 10 15 20
  1 6 11 16 21
  2 7 12 17 22
  3 8 13 18 24
  4 9 14 19 24
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
- -> Ch. 1 - 6 = Act 1, Ch. 7 - 18 = Act 2, Ch. 19 - 24 = Act 3
- With our (as square as possible) Matrix, we assign Act lengths following the 25/50/25 novel distribution
- -> We now answer the "Five Building Block Questions" within each Act, assigning each question to a Chapter
- -> The questions for each Act CANNOT overlap with the diagonal of our Matrix
- -> Following the 25/50/25 novel distribution, we need two Chapters per question in Act 2, which is twice that of Acts 1 and 3
- We are now ready to evaluate each Sequence/Chapter, which we equate to one Round of French Tarot
- For each Round, we answer the "Five Building Block Questions" based on turn order in the Round:
- -> Player 1 = The Trick = Inciting Incident = Facts
- -> Player 2 = The Defense (Part 1) = Complication + Crisis = Consequences
- -> Player 3 = The Defense (Part 2) = Climax = Emotions - Resolution
- -> The Resolution is responsible for two story aspects:
- -> 1. Climax + "Resolution" = Emotions
- -> 2. Resolution = Round Winner = Controls the next Round's Inciting Incident
- -> The above ties together each consecutive Sequence/Chapter through Resolution -> Inciting Incident, looping on our building block narrative structure
- We now evaluate each Scene within each Chapter, where Scene = Card played in Round
- -> Each Card must answer the "Five Building Block Questions" from the perspective of the Character that played the Card
- We do NOT define Beats in our Algorithm, to give our output enough flexibility in finalizing the writing of our story.

We have now answered all building block questions for all our defined layers of story.
- This means we now need to generate our Rough Draft Output using our Matrix dataset.

## Installation
Blah

## Usage
Blah

## Resources
https://tarotx.net/
https://en.wikipedia.org/wiki/French_Tarot
https://storygrid.com/how-to-learn-writing/



## NOTES
Tarot Suit Rankings:
wands, batons, or rods (clubs); cups (hearts); swords (spades); and coins, pentacles, or disks (diamonds)


Body reading notes:
between every shuffle, take one half of the cards and invert their orientation, 
to maintain a certain number of reversed cards.


Three part novel builder logic:
Part 1 - beginning of story
Part 2 - first round with a trump played
Part 3 - first round with three (or two) trumps played


Story Grid Book Notes:

Ch. 11
- story graph example for Silence of the Lambs
- Six Editor Questions:
1. What's the Genre?
2. What are the conventions and obligatory scenes for that Genre?
3. What's the point of view?
4. What are the protagonist's objects of desire?
5. What's the controlling idea/theme?
6. What is the Beginning Hook, the Middle Build, and Ending Payoff?
- Also think on how this concept applies to acting, jokes, composing and coding.

Ch. 16 
- think of how to abstract Genres into a list of relevant conventions and obligatory scenes, to then make a checklist for our review process 
- (if we cover all the topics in our list, then we pass)
- Genre Five-Leaf Clover (organizes most known Genre categorizations into five expectation groups: Time, Reality, Style, Structure, Content)

Ch. 18
- Story Bell Curve (x-axis: Mini-Plot, Arch-Plot, Anti-Plot; y-axis: Potential Audience)

Ch. 22
- Boiling down both Arch-Plot and Mini-Plot Structure Genres lead to describing "The Hero's Journey"
- Inner Conflict, Personal Conflict and Extra-Personal Conflict
- Focus on the struggle to get objects of desire
- character wants and needs

Ch. 23
- External Content Genres (what characters want)
- Internal Content Genres (what characters need)

NOTE: Remember that Genres are fluid, and can morph into each other at any point in a book

Ch. 25
- Most stories that last a few seasons or over 10 novels require the usage of both External and Internal Content Genres

Ch. 27
- The Foolscap Method is comparable in strategy to the Story Grid Method, and can be used as a "process derivative" if relevant

Ch. 28
- The Foolscap Global Story Grid sheet is a one-page summary of a novel that answers the Six Editor Questions from Ch. 11
- Look to page 114 for the one-page form to fill out
- If you can fill out this one-page form after reading a book, then the book "passes the test"

Ch. 30
- Story Value is categorized as a human experience that can shift from positive to negative, or vice versa
- Walk through the assignment of numerical values to all parts of the Story Value Spectrum (this could be coded)
- "The Negation of the Negation" and how it appears in your story

Ch. 32
- First Person, Second Person, Third Person
- Do not shift too much in the story

Ch. 34
- pages 137 and 138 for definition of Controlling Idea and example description, respectively

Ch. 36
- use this chapter to come up with coded parameters for actual novel structure (pages, words, etc)

Ch. 37
- page 148 is the Kubler-Ross Change Curve For Story
- keep in mind curve proportions: 25%/50%/25% is a standard generalization, and can be played around with

Ch. 39
- BEATS!!! lol, it's beat structure, which also happens to be the same structure for all story components:
1. Inciting Incident
a. Casual
b. Coincidence

2. Progressive Complication
a. Active Turning Point
b. Revelatory Turning Point

3. Crisis
a. The Best Bad Choice
b. Irreconcilable Goods

4. Climax

5. Resolution

- Beats (smallest unit of story) 
-> Scenes (basic building blocks of story) 
-> Sequences (minor life stages in story)
-> Acts (major life stages in story)
-> Subplots (controlling theme amplifiers, useful in long story formats)
-> Global Story (what the author is trying to say)
- every unit of story follows the same five principles listed above

Ch. 42
- Turning Points are little buddies to Progressive Complications
- if decisions and actions are easily reversible, then no story; make sure you can't go backwards easily

Ch. 53
- Be aware of Paralysis by Analysis, which is planning out Global Story before writing anything

Ch. 59
- Use the Foolscap Global Story Grid on two scales: Micro and Macro
- Micro Scale (analyze whole work Scene by Scene, keeping track of all building blocks, pages 236 - 253)
- Macro Scale (analyze whole work overall, keeping track of all building blocks, use one-page form)

Ch. 66
- Combining Micro Scale and Macro Scale Story Grids to make the overarching story grid



Sentence Structuring:
- there are five important nouns: Person, Thing, Idea, Quality, Action (Place and Animal do not apply)
- We need to assign each of these noun types to one of the Five Questions
- We have the following:
- -> Inciting Incident: "The __(Thing)__ happens."
- -> Complication: "The __(Person)__ gets involved."
- -> Crisis: "The __(Idea)__ becomes known."
- -> Climax: "The __(Action)__ is taken."
- -> Resolution: "The __(Quality)__ is achieved."
