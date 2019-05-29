package com.LirimKusari;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GUI extends JPanel{

    String p1CardSuit;
    int    p1CardCount;
    String p2CardSuit;
    int    p2CardCount;

    JFrame f = new JFrame();

    private int width  = 1280 ;
    private int height = 720;

    private int widthUnit=width/16;
    private int heightUnit=height/10;

    private int cardWidth = widthUnit*2;
    private int cardHeight = heightUnit*3;

    private int horizontalDeckSpace = widthUnit;
    private int verticalDeckSpace   = heightUnit;

    private int spaceBetweenCards = 100/2;

//----------------------------------------------------------------------------------------------------------------------

    public GUI(){}// num perdoret

//    public GUI(ArrayList<Card>  player1 , ArrayList<Card> player2){
//        p1Cardsuit = player1.get(0).getSuit();
//        p1cardCount = player1.get(0).getCount();
//
//        p2Cardsuit = player2.get(0).getSuit();
//        p2cardCount = player2.get(0).getCount();
//    }

    public GUI(int i){
            Mouse mouse = new Mouse();
            f.addMouseListener(mouse);
            f.setTitle("War CardGame");
            f.setSize(width+17, height+40);
            f.getContentPane().add(this);
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.setVisible(true);

        }

//----------------------------------------------------------------------------------------------------------------------

    public void paint(Graphics g){
       mainScreen(g);
       paintP1Card(g);
       paintP2Card(g);
       repaint(10);


    }

//----------------------------------------------------------------------------------------------------------------------


    private void mainScreen(Graphics g ){
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);

        g.setColor(Color.blue);
        g.fillRect(horizontalDeckSpace,height-cardHeight-verticalDeckSpace, cardWidth,cardHeight);

        g.setColor(Color.red);
        g.fillRect(width-cardWidth-horizontalDeckSpace,verticalDeckSpace,cardWidth,cardHeight);

        g.setColor(Color.WHITE);
        g.fillRect(width/2-cardWidth-spaceBetweenCards,height/2-cardHeight/2,cardWidth,cardHeight);
        g.fillRect(width/2+spaceBetweenCards,height/2-cardHeight/2,cardWidth,cardHeight);
    }

    public void paintP1Card(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(width/2-cardWidth-spaceBetweenCards,height/2-cardHeight/2,cardWidth,cardHeight);
        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
        g.drawString(p1CardSuit+"",width/2-cardWidth-spaceBetweenCards+10,height/2-cardHeight/2+40);


    }
    public void paintP2Card(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(width/2+spaceBetweenCards,height/2-cardHeight/2,cardWidth,cardHeight);
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
        g.drawString(p1CardSuit+"",width/2+spaceBetweenCards+10,height/2-cardHeight/2+40);
    }

//----------------------------------------------------------------------------------------------------------------------


    public int getP1CardCount() {
        return p1CardCount;
    }

    public String getP1CardSuit() {
        return p1CardSuit;
    }

    public int getP2CardCount() {
        return p2CardCount;
    }
    public int getP2CardSuit() {
        return p2CardCount;
    }
}


