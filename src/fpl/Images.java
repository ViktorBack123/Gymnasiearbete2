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
            case "Arsenal"-> image = new ImageIcon(arsenal);
            case "Aston Villa"-> image = new ImageIcon(astonVilla);
            case "Bournemouth"-> image = new ImageIcon(bournemouth);
            case "Brentford"-> image = new ImageIcon(brentford);
            case "Brighton"-> image = new ImageIcon(brighton);
            case "Chelsea"-> image = new ImageIcon(chelsea);
            case "Crystal Palace"-> image = new ImageIcon(crystalPalace);
            case "Everton"-> image = new ImageIcon(everton);
            case "Fulham"-> image = new ImageIcon(fulham);
            case "Leeds United"-> image = new ImageIcon(leeds);
            case "Leicester City"-> image = new ImageIcon(leicester);
            case "Liverpool"-> image = new ImageIcon(liverpool);
            case "Manchester City"-> image=new ImageIcon(manchesterCity);
            case "Manchester Utd"-> image=new ImageIcon(manchesterUnited);
            case "Newcastle Utd"-> image=new ImageIcon(newcastle);
            case "Nott'ham Forest"-> image=new ImageIcon(nottingham);
            case "Southampton"-> image=new ImageIcon(southampton);
            case "Tottenham"-> image=new ImageIcon(tottenham);
            case "West Ham"-> image=new ImageIcon(westHam);
            case "Wolves"-> image=new ImageIcon(wolverhampton);
        }

        assert image != null;
        Image originalBild = image.getImage();
        Image bildNyStorlek = originalBild.getScaledInstance(45,60,Image.SCALE_DEFAULT);
        ImageIcon ny = new ImageIcon(bildNyStorlek);

        return new JLabel(ny);
    }




}
