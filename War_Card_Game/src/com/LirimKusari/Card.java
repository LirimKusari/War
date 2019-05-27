package com.LirimKusari;

import java.awt.image.BufferedImage;

/**
 * Card  models a playing card
 */
public class Card { // definitions that one can use to describe the value of a card:
    public static final String SPADES = "spades";
    public static final String HEARTS = "hearts";
    public static final String DIAMONDS = "diamonds";
    public static final String CLUBS = "clubs";

    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    private BufferedImage image;

    public static final int SIZE_OF_ONE_SUIT = 13;

    private String suit;
    private int count;

//=---------------------------------------------------------------------------------------------------------------------

    public Card(String s, int c  ) {//BufferedImage i
        suit = s;
        count = c;
       // image=i;
    }
//=---------------------------------------------------------------------------------------------------------------------

    public String getSuit() {
        return suit;
    }

    public int getCount() {
        return count;
    }
}