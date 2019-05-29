package com.LirimKusari;

import java.util.ArrayList;
import java.util.List;

public class GameActions {

    private final int firstCard = 0;

    CardDeck cd = new CardDeck();

    // List<Card> allCards = cd.getDecklist();     // never used

    ArrayList<Card> player1 = new ArrayList<Card>();
    ArrayList<Card> player2 = new ArrayList<Card>();
    ArrayList<Card> cardsOnTable = new ArrayList<Card>();


    Card p1=null;
    Card p2=null;


//=---------------------------------------------------------------------------------------------------------------------

    public GameActions(int i) {
        splitDecks();
        playerDecks();
        System.out.println("GameAction 1 Initialized split deck  __ mouse");
    }

    public GameActions() {
        for (int j =0;j<100;j++ ){
            placeCard();
            System.out.println();
            taceCard();
        }

    }
//=---------------------------------------------------------------------------------------------------------------------

    // splits the cards and distributes to players.
    public void splitDecks() {
        for (int i = 0; i < (cd.decklist.size()) / 2; i++) {
            player1.add(i, cd.decklist.get(i));
            player2.add(i, cd.decklist.get((cd.decklist.size() - 1) - i));

        }
        System.out.println("\n the deck has been split \n");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n");

    }

    // print out the cards the players have.
    public void playerDecks() {
        // Player 1 cards
        System.out.println("\n   Player1 card's are: \n");
        for (int i = 0; i < player1.size(); i++) { //Card p1Card : player1
            System.out.print(" " + (i + 1) + ". " + player1.get(i).getCount());
            System.out.println(" " + player1.get(i).getSuit());
        }
        // Player 2 cards
        System.out.println("\n   Player2 card's are: \n");
        for (int i = 0; i < player2.size(); i++) { //Card p2Card : player2
            System.out.print(" " + (i + 1) + ". " + player2.get(i).getCount());
            System.out.println(" " + player2.get(i).getSuit());
        }
    }

//=---------------------------------------------------------------------------------------------------------------------

    // places the card on the table.
    // chacks for war.
    // places the cards on the table.
    public void placeCard() {

        if (player1.size() == 1 || player2.size() == 1) {
            if (player1Winer()) {
                System.out.println("Player 1 wins \n" + "Game Over");
                System.exit(0);
            } else {
                System.out.println("Player 2 wins \n" + "Game Over");
                System.exit(0);
            }

        } else if (player1.size() != 0 || player2.size() != 0) {
            if (war()) {
                System.out.println("It is time for WAR");
                System.out.println("Player 1-s cars is  the " + player1.get(firstCard).getCount() + " of " + player1.get(firstCard).getSuit());
                System.out.println("Player 2-s cars is  the " + player2.get(firstCard).getCount() + " of " + player2.get(firstCard).getSuit());
                p1= player1.get(0);
                p2= player2.get(0);

                transferToTable(player1, player2, cardsOnTable);
            } else {
                System.out.println("Player 1-s cars is  the " + player1.get(firstCard).getCount() + " of " + player1.get(firstCard).getSuit());
                System.out.println("Player 2-s cars is  the " + player2.get(firstCard).getCount() + " of " + player2.get(firstCard).getSuit());
                System.out.println("Normal round");
                transferToTable(player1, player2, cardsOnTable);

            }
        }

        // gui. place player 1 card on the board

    }

    // checks for winner and gives him the cards.
    public void taceCard() {

            if (player1Winer() == true) {
                System.out.println("Player 1 is the winner");

                transferToWinnersDeck(player1, cardsOnTable);
            } else {
                System.out.println("Player 2 is the winner");

                transferToWinnersDeck(player2, cardsOnTable);
            }
            playerDecks();
            // gui. place player 2 card on the board
        }


//=-------------------------------------------------------------------------------------------------------------

    /**
     * @param player1 Cards will be placed(transfered) to the table for player1.
     * @param player2 Cards will be placed(transfered) to the table for player2.
     * @param table   The table.
     */
    public void transferToTable(List<Card> player1, List<Card> player2, List<Card> table) {
        int i = 0;
        if (war() == true) {
            i = 4;
        } else if (war() == false) {
            i = 1;
        }

        for (int j = 0; j < i; j++) {

                if (player1.size() == 0 && player2.size() == 0) {

                    System.out.println("GameOver");
                    System.exit(0);
                } else {

                    // transfer then remuve firstCard from the winnig players deck
                    addCard(table, player1, firstCard);
                    remuveCard(player1, firstCard);
                    System.out.println("Placed card from player 1 on the table");

                    // transfer the remuve firstCard from the losing players deck
                    addCard(table, player2, firstCard);
                    remuveCard(player2, firstCard);
                    System.out.println("Placed card from player 2 on the table");


                }
            }
        }




    /**
     * @param winner The player that will tace the cards on the table.
     * @param table  The winner will take the cards from here (card placed on the table).
     */
    public void transferToWinnersDeck(List<Card> winner, List<Card> table) {
        int i = cardsOnTable.size();
        int j = 0;
        while (j < i) {
            addCard(winner, table, firstCard);
            remuveCard(cardsOnTable, firstCard);
            j++;
        }

    }

//=-------------------------------------------------------------------------------------------------------------

    // is it time for war
    private boolean war() {
        boolean rez = false;
        if (player1.get(firstCard).getCount() == player2.get(firstCard).getCount()) {
            rez = true;
        }
        return rez;
    }

    //  Is player1 teh winner of the round ?
    public boolean player1Winer() {
        boolean rez = false;
        if (player1.get(firstCard).getCount() > player2.get(firstCard).getCount()) {
            rez = true;
        }
        return rez;
    }

    /**
     * @param player   One of the players List (cards) we will remove a card from.
     * @param position The position on the list were we will remove the card at.
     */
    private void remuveCard(List<Card> player, int position) {
        if (player.size() != 0) {
            player.remove(position);
        }
    }

    /**
     * @param receaver the grupe of cards(Player1 or Player 2 or The Cards On the Table) that is goin to receave a card(a object of class card is going to be transfered).
     * @param giver    the grupe of cards we are going to tace a card from.
     * @param position the position in the deck were the card is going to be taken  .
     */
    private void addCard(List<Card> receaver, List<Card> giver, int position) {
        if (giver.size() != 0) {
            receaver.add(giver.get(position));
        }
    }

//=-------------------------------------------------------------------------------------------------------------


    public ArrayList<Card> getPlayer1card() {
        return player1;
    }

    public ArrayList<Card> getPlayer2card() {
        return player2;
    }
}