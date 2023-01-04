package fpl;

import javax.swing.*;
import java.awt.*;

public class Players extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*             Alla möjliga laguppställningar
        Ett lag får max ha 11 spelare varav en är målvakten. Laget måste ha mellan
        3-5 försvarare, mellan 2-5 mittfältare och mellan 1-3 anfallare.
        De möjliga laguppställningarna är därmed följande:
        4-4-2
        4-3-3
        4-5-1
        5-4-1
        5-3-2
        5-2-3
        3-4-3
        3-5-2
         */

        // 4-4-2

        // Målvakten:
        /*g.setColor(Color.BLACK);
        g.fillRect(225, 50, 35, 50);

        // Backlinjen:
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(75+100*i,150, 35, 50);


        }

        // Mittfältare:
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(75+100*i,250, 35, 50);

        }

        // Anfallare:
        for (int i = 0; i < 2; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(175+100*i,350, 35, 50);


        }

         */



        // 4-3-3

        // Målvakten:
        /*g.setColor(Color.BLACK);
        g.fillRect(225, 50, 35, 50);

        // Backlinjen:
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(75+100*i,150, 35, 50);
        }

        // Mittfältare:
        for (int i = 0; i < 3; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(125+100*i,250, 35, 50);

        }

        // Anfallare:
        for (int i = 0; i < 3; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(125+100*i,350, 35, 50);


        }

         */



        // 4-5-1

        // Målvakten:
        g.setColor(Color.BLACK);
        g.fillRect(225, 50, 35, 50);

        // Backlinjen:
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(75+100*i,150, 35, 50);
        }

        // Mittfältare:
        for (int i = 0; i < 5; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(25+100*i,250, 35, 50);

        }

        // Anfallare:
        for (int i = 0; i < 1; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(225,350, 35, 50);


        }



    }

}


