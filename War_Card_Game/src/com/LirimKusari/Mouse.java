package com.LirimKusari;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {

    GameActions ga = new GameActions(1);

    int xpos = 0;
    int ypos = 0;
    int queue = 1;

//----------------------------------------------------------------------------------------------------------------------

    public void mouseClicked(MouseEvent event) {
    }
    public void mouseReleased(MouseEvent event) {
        xpos = event.getX();
        ypos = event.getY();
//        System.out.println("xpos = "+xpos+"  "+"ypos = "+ypos);
        player1Play(xpos, ypos);
        player2Play(xpos, ypos);

    }

    public void mouseEntered(MouseEvent event) {
        System.out.println("The mouse has entered the frame");
    }

    public void mousePressed(MouseEvent event) {
    }
    public void mouseExited(MouseEvent event) {
    }

//----------------------------------------------------------------------------------------------------------------------

    public void player1Play(int xpos, int ypos) {
        if ((xpos < 248 && xpos >88) && (ypos >463 && ypos < 678) && (queue % 2 == 1)) {
            ga.placeCard();
            queue++;
        }
    }
    public void player2Play(int xpos, int ypos) {
        if ((xpos < 1208 && xpos > 1048) && (ypos >103&& ypos < 318) && (queue % 2 == 0)) {
            ga.taceCard();
            queue++;

        }
    }



//----------------------------------------------------------------------------------------------------------------------
}


