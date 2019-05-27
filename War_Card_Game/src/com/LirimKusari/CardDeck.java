package com.LirimKusari;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

//=---------------------------------------------------------------------------------------------------------------------

    private int card_count;  // how many cards remain in the deck
    List<Card> decklist = new ArrayList<Card>();

    public CardDeck() {
        createSuit(Card.SPADES);
        createSuit(Card.HEARTS);
        createSuit(Card.CLUBS);
        createSuit(Card.DIAMONDS);
        Collections.shuffle(decklist);
        printlist();

    }

    public boolean moreCards() {
        return (card_count > 0);
    }
//=---------------------------------------------------------------------------------------------------------------------

    private void createSuit(String which_suit) {
        for (int i = 1; i <= Card.SIZE_OF_ONE_SUIT; i = i + 1) {
            decklist.add(new Card(which_suit, i));
            card_count = card_count + 1;
        }
    }

    public void printlist() {
//        System.out.println("The size of the deck is"+ decklist.size());
        for (int i=0; i<decklist.size();i++){
//            System.out.println((i+1)+" "+decklist.get(i).getCount());
        }

    }

    public List<Card> getDecklist() {
        return decklist;
    }



}