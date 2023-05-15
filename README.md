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
- For three players, there are 24 rounds of play, six card dog
- For four players, there are 18 rounds of play, six card dog
- For five players, there are 15 rounds of play, three card dog
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
Each layer of story MUST answer these building block questions.
- We define the different layers 
1. Beats (the smallest unit of story)
2. Scenes (basic building blocks of story)
3. Sequences / Chapters (minor life stages in story)
4. Acts (major life stages in story)
5. Subplots (controlling theme amplifiers, useful in long story formats)
6. Global Story (what the author is trying to say)
- We call these questions the "Five Building Block Questions," denoted as FBBQ.

We have created the following sentence templates:
1. Inciting Incident = Subject (Player) + Upright Verb + Upright Direct Object (Noun)
2. Complication = Subject (Player) + Reversed Verb + Reversed Direct Object (Noun)
3. Crisis = Question Word (D6, What, Where, Why, Who, When, How) + Auxiliary Verb (D7, Be, Do, Can, May, Have, Will, Should) + Subject (Player) + Reversed Verb + ?
4. Climax = Subject (Player) + Upright Verb + Upright Direct Object (Noun)
5. Resolution = Subject (Player) + Upright Verb + Upright Direct Object (Noun) + Conjunctive (D8, For, And, But, Or, Yet, So, However, Therefore) + Subject (Player) + Reversed Verb + Reversed Direct Object (Noun)

To summarize everything we have discussed:
- We can now relate the card interpretations directly to the narrative building blocks using noun extrapolation.
- This is the connection we implement in our algorithm to have a game of French Tarot generate us a narrative.

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
Run the following command in terminal inside the project:
`mvn -X -U clean test -Dprop.file=src/main/resources/config.properties`

## Development

## Testing

## Resources
https://tarotx.net/
https://en.wikipedia.org/wiki/French_Tarot
https://storygrid.com/how-to-learn-writing/




## NOTES
### Story Grid Book Notes
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

### Narrative Structure Notes
- The definition of a noun contains the following subtypes: Person, Thing, Idea, Quality, Action (Place and Animal are less human-centric, and therefore ignored)
- We assign each of these noun types to one of the Five Questions. We extrapolate the meaning of each of the Five Questions to create the following relationship:
- -> Inciting Incident: "The __(Thing)__ happens."
- -> Complication: "The __(Person)__ gets involved."
- -> Crisis: "The __(Idea)__ becomes known."
- -> Climax: "The __(Action)__ is taken."
- -> Resolution: "The __(Quality)__ is achieved."

### Algorithm Notes
- We now consider how exactly to "interpret" each Tarot card in a way that translates to our previously described building blocks.
- We use the foundation for a DBT skill to obtain archetypal data from each card.
- This skill is known as the "Mindfulness Non-Judgmental" skill, and is composed of the following:
1. What are the Facts of a given situation?
2. What are the Consequences of a given situation?
3. What are the Emotions of a given situation?
- We call these three questions the "FCE"
- Each question is answered with a list of archetypal answers that reflect both positive and negative perspectives of the card interpretation.

- What we choose to do is equate "Five Questions" to "FCE" as follows:
- Five Questions = FCE
- -> Inciting Incident + (Complication + Crisis) + (Climax + Resolution) = Facts + Consequences + Emotions
- -> Inciting Incident ~= Facts (What are the Facts ~= What was Incited)
- -> (Complication + Crisis) ~= Consequences (What are the Consequences ~= Complication -> Crisis narrative development)
- -> (Climax + Resolution) ~= Emotions (What are the Emotions ~= Climax -> Resolution narrative development)
- We use this relationship as our main connector between the game of French Tarot and the archetypal interpretation of each card.
- However, we have an immediate issue: Five Questions are full sentences and FCE are lists of words.
- We need to figure out how to use the words in FCE as the responses to the Five Questions

- The definition of a noun contains the following subtypes: Person, Thing, Idea, Quality, Action (Place and Animal are less human-centric, and therefore ignored)
- We assign each of these noun types to one of the Five Questions. We extrapolate the meaning of each of the Five Questions to create the following relationship:
- -> Inciting Incident: "The __(Thing)__ happens."
- -> Complication: "The __(Person)__ gets involved."
- -> Crisis: "The __(Idea)__ becomes known."
- -> Climax: "The __(Action)__ is taken."
- -> Resolution: "The __(Quality)__ is achieved."

- We now have the following narrative equations:
1. Inciting Incident ~= Facts ~= "The __(Thing)__ happens."
2. Complication ~= Consequences ~= "The __(Person)__ gets involved."
3. Crisis ~= Consequences ~= "The __(Idea)__ becomes known."
4. Climax ~= Emotions ~= "The __(Action)__ is taken."
5. Resolution ~= Emotions ~= "The __(Quality)__ is achieved."
- Notice the overlap of Emotions and Consequences; Consequences can describe both Complications and Crises, and Emotions can describe both Climaxes and Resolutions

- To summarize everything we have discussed:
- -> We can now relate the card interpretations directly to the narrative building blocks using noun extrapolation.
- -> This is the connection we implement in our algorithm to have a game of French Tarot tell us a narrative.