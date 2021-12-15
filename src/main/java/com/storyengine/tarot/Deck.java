package com.storyengine.tarot;

import java.util.Random;

public class Deck {
    private Card[] cards;
    private Random rand;
    
    Deck() {
        rand = new Random();
        cards = new Card[78];
        //Major Arcana
        cards[0] = new Card("The Fool", "Innocence, New Beginnings, Wonder, Foolishness");
        cards[1] = new Card("The Magician", "Willpower, Creation, Mastery, Adaptation");
        cards[2] = new Card("The High Priestess", "Inner Voice, Intuition, Divine Truth, Wisdom, Unconscious");
        cards[3] = new Card("The Empress", "Beauty, Fertility, Nurturing, Luxury, Creativity");
        cards[4] = new Card("The Emperor", "Structure, Ambition, Authority, Rationality");
        cards[5] = new Card("The Hierophant", "Tradition, Legacy, Society, Organized Religion");
        cards[6] = new Card("The Lovers", "Choices, Union, Love, Relationship");
        cards[7] = new Card("The Chariot", "Self-Control, Discipline, Success");
        cards[8] = new Card("Strength", "Courage, Inner Strength, Conviction, Compassion");
        cards[9] = new Card("The Hermit", "Contemplation, Solitude, Insight, Awareness");
        cards[10] = new Card("The Wheel of Fortune", "Fate, Karma, Destiny, Fortune, Cycles");
        cards[11] = new Card("Justice", "Truth, Fairness, Law, Clarity, Cause and Effect");
        cards[12] = new Card("The Hanged Man", "Sacrifice, Suspension, Release, Martyrdom, New Perspective");
        cards[13] = new Card("Death", "End of Cycle, New Beginnings, Change, Metamorphosis");
        cards[14] = new Card("Temperance", "Middle Path, Patience, Finding Meaning");
        cards[15] = new Card("The Devil", "Materialism, Playfulness, Pleasure, Addiction, Self-Destruction");
        cards[16] = new Card("The Tower", "Upheaval, Disaster, Foundational Shift");
        cards[17] = new Card("The Star", "Hope, Faith, Rejuvenation, Rebuilding, Healing");
        cards[18] = new Card("The Moon", "Unconscious, Illusions, Intuition, Lack of Clarity");
        cards[19] = new Card("The Sun", "Joy, Success, Celebration, Pleasure");
        cards[20] = new Card("Judgement", "Reflection, Reckoning, Awakening");
        cards[21] = new Card("The World", "Fulfillment, Harmony, Completion");
        
        //Suit of Cups
        cards[22] = new Card("Ace of Cups", "New Feelings, Spirituality, Intuition");
        cards[23] = new Card("Two of Cups", "Unity, Partnership, Connection");
        cards[24] = new Card("Three of Cups", "Friendship, Community, Happiness");
        cards[25] = new Card("Four of Cups", "Apathy, Contemplation, Disconnection");
        cards[26] = new Card("Five of Cups", "Loss, Grief, Disappointment, Mourning");
        cards[27] = new Card("Six of Cups", "Familiarity, Memories, Healing, Restoration");
        cards[28] = new Card("Seven of Cups", "Searching for Purporse, Choices, Daydreaming");
        cards[29] = new Card("Eight of Cups", "Walking Away, Disillusionment, Leaving Something Behind");
        cards[30] = new Card("Nine of Cups", "Satisfaction, Luxury, Emotional Stability");
        cards[31] = new Card("Ten of Cups", "Inner Happiness, Fulfillment, Dreams Coming True");
        cards[32] = new Card("Page of Cups", "Happy Surprise, Dreamer, Sensitiviry");
        cards[33] = new Card("Knight of Cups", "Idealistic, Romantic, Following One's Heart");
        cards[34] = new Card("Queen of Cups", "Compassion, Calm, Comfort");
        cards[35] = new Card("King of Cups", "Emotional Control, Balance Between Heart and Head");
        
        //Suit of Pentacles
        cards[36] = new Card("Ace of Pentacles", "Opportunity, Prosperity, New Venture");
        cards[37] = new Card("Two of Pentacles", "Balancing Decisions, Priorities, Adaptation");
        cards[38] = new Card("Three of Pentacles", "Teamwork, Collaboration, Building Together");
        cards[39] = new Card("Four of Pentacles", "Conservation, Security, Frugality");
        cards[40] = new Card("Five of Pentacles", "Need, Poverty, Insecurity, Low Resources");
        cards[41] = new Card("Six of Pentacles", "Charity, Generosity, Sharing");
        cards[42] = new Card("Seven of Pentacles", "Hard Work, Perserverance, Diligence");
        cards[43] = new Card("Eight of Pentacles", "Diligence, Passion, High Standards");
        cards[44] = new Card("Nine of Pentacles", "Fruits of Labour, Reckless Spending, Rewards");
        cards[45] = new Card("Ten of Pentacles", "Legacy, Inheritance, Culmination");
        cards[46] = new Card("Page of Pentacles", "Ambition, Desire, Diligence, Craving New Venture");
        cards[47] = new Card("Knight of Pentacles", "Efficiency, Hard Work, Responsibility");
        cards[48] = new Card("Queen of Pentacles", "Practicality, Creature Comforts, Security");
        cards[49] = new Card("King of Pentacles", "Abundance, Prosperity, Provider, Generosity");
        
        //Suit of Wands
        cards[50] = new Card("Ace of Wands", "Creation, Willpower, Inspiration, Desire");
        cards[51] = new Card("Two of Wands", "Planning, Making Decisions, Leaving Home");
        cards[52] = new Card("Three of Wands", "Looking Ahead, Expansion, Rapid Growth");
        cards[53] = new Card("Four of Wands", "Community, Home, Celebration");
        cards[54] = new Card("Five of Wands", "Competition, Conflict, Reality");
        cards[55] = new Card("Six of Wands", "Victory, Success, Public Reward");
        cards[56] = new Card("Seven of Wands", "Perserverance, Mounting A Defence, Maintaining Control");
        cards[57] = new Card("Eight of Wands", "Rapid Action, Monument, Quick Decisions");
        cards[58] = new Card("Nine of Wands", "Resilience, Grit, Taking Last Stand");
        cards[59] = new Card("Ten of Wands", "Accomplishment, Responsibility, Burden");
        cards[60] = new Card("Page of Wands", "Exploration, Excitement, Freedom");
        cards[61] = new Card("Knight of Wands", "Action, Adventure, Fearlessness");
        cards[62] = new Card("Queen of Wands", "Courage, Determination, Passion, Joy");
        cards[63] = new Card("King of Wands", "Big Picture, Leader, Overcoming Challenges");
        
        //Suit of Swords
        cards[64] = new Card("Ace of Swords", "Breakthrough, Clarity, Sharp Mind");
        cards[65] = new Card("Two of Swords", "Difficult Choices, Indecision, Stalemate");
        cards[66] = new Card("Three of Swords", "Heartbreak, Suffering, Grief");
        cards[67] = new Card("Four of Swords", "Rest, Restoration, Contemplation");
        cards[68] = new Card("Five of Swords", "Unbridled Ambition, Win At All Costs, Sneakiness");
        cards[69] = new Card("Six of Swords", "Transition, Leaving Behind, Moving On");
        cards[70] = new Card("Seven of Swords", "Deception, Trickery, Tactics and Strategy");
        cards[71] = new Card("Eight of Swords", "Imprisonment, Entrapment, Self-Victimization");
        cards[72] = new Card("Nine of Swords", "Anxiety, Hopelessness, Trauma");
        cards[73] = new Card("Ten of Swords", "Failure, Collapse, Defeat, Backstabbing");
        cards[74] = new Card("Page of Swords", "Curiosity, Restlessness, Mental Energy");
        cards[75] = new Card("Knight of Swords", "Action, Impulsiveness, Defending Beliefs");
        cards[76] = new Card("Queen of Swords", "Complexity, Perceptive, Clear Mindedness");
        cards[77] = new Card("King of Swords", "Head Over Heart, Truth, Discipline");        
    }
    
    public void draw() {
        int pick = rand.nextInt(78);
        cards[pick].display();
    }
}
