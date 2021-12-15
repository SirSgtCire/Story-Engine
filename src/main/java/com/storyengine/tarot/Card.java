package com.storyengine.tarot;

public class Card {
    private String title;
    private String keywords;
    
    public Card(String title, String keywords) {
        this.title = title;
        this.keywords = keywords;
    }

    public void display() {
        System.out.println("Card: " + title);
        System.out.println("Keywords: " + keywords);
    }
}
