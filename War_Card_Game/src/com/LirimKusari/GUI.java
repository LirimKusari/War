package com.LirimKusari;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    JFrame f= new JFrame();
    Image img = Toolkit.getDefaultToolkit().createImage("4D.png");
    ImageIcon image  =new ImageIcon("TableN.jpg");
    JLabel l= new JLabel(image);

    GUI(){

        int width  = 1080;
        int height = 720;

        f.setTitle("War CardGame");
        f.setVisible(true);
        f.setSize(width, height);
        f.getContentPane().add(this);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(l);


    }


    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(0,0,1000,1000);

        g.drawImage(img,0,0,null);

    }
//=---------------------------------------------------------------------------------------------------------------------

    public void dragCardPlayer1(){};
    public void dragCardPlayer2(){};

    public void placeCard1(){};
    public void placeCard2(){};

    public void remuvaCardsFromTable(){};

    public void  addCardsPlayer1(){};
    public void addCardsPlayer2(){};

    public void placeCardBackwardsPlayer1(){};
    public void placeCardBackwardsPlayer2(){};


    }


