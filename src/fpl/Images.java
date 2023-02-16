package fpl;

import javax.swing.*;
import java.awt.*;

public class Images {
    String arsenal = "shirts\\arsenal.jpg";
    String astonVilla = "shirts\\astonVilla.jpg";
    String bournemouth = "shirts\\bournemouth.jpg";
    String brentford = "shirts\\brentford.jpg";
    String brighton = "shirts\\brighton.jpg";
    String chelsea = "shirts\\chelsea.jpg";
    String crystalPalace = "shirts\\crystalPalace.jpg";
    String everton = "shirts\\everton.jpg";
    String fulham = "shirts\\fulham.jpg";
    String leeds = "shirts\\leeds.jpg";
    String leicester = "shirts\\leicester.jpg";
    String liverpool = "shirts\\liverpool.jpg";
    String manchesterCity = "shirts\\manchesterCity.jpg";
    String manchesterUnited = "shirts\\manchesterUnited.jpg";
    String newcastle = "shirts\\newcastle.jpg";
    String nottingham = "shirts\\nottingham.jpg";
    String southampton = "shirts\\southampton.jpg";
    String tottenham = "shirts\\tottenham.jpg";
    String westHam = "shirts\\westHam.jpg";
    String wolverhampton = "shirts\\wolverhampton.jpg";

    public JComponent getImage(String team){
        ImageIcon image = null;


        switch (team){
            case "arsenal"-> image = new ImageIcon(arsenal);
            case "astonVilla"-> image = new ImageIcon(astonVilla);
            case "bournemouth"-> image = new ImageIcon(bournemouth);
            case "brentford"-> image = new ImageIcon(brentford);
            case "brighton"-> image = new ImageIcon(brighton);
            case "chelsea"-> image = new ImageIcon(chelsea);
            case "crystalPalace"-> image = new ImageIcon(crystalPalace);
            case "everton"-> image = new ImageIcon(everton);
            case "fulham"-> image = new ImageIcon(fulham);
            case "leeds"-> image = new ImageIcon(leeds);
            case "leicester"-> image = new ImageIcon(leicester);
            case "liverpool"-> image = new ImageIcon(liverpool);
            case "manchesterCity"-> image=new ImageIcon(manchesterCity);
            case "manchesterUnited"-> image=new ImageIcon(manchesterUnited);
            case "newcastle"-> image=new ImageIcon(newcastle);
            case "nottingham"-> image=new ImageIcon(nottingham);
            case "southampton"-> image=new ImageIcon(southampton);
            case "tottenham"-> image=new ImageIcon(tottenham);
            case "westHam"-> image=new ImageIcon(westHam);
            case "wolverhampton"-> image=new ImageIcon(wolverhampton);
        }

        assert image != null;
        Image originalBild = image.getImage();
        Image bildNyStorlek = originalBild.getScaledInstance(45,60,Image.SCALE_DEFAULT);
        ImageIcon ny = new ImageIcon(bildNyStorlek);

        return new JLabel(ny);
    }



}
