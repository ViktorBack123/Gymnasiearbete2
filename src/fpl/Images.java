package fpl;

import javax.swing.*;
import java.awt.*;

public class Images {
    private final String arsenal = "shirts\\arsenal.jpg";
    private final String astonVilla = "shirts\\astonVilla.jpg";
    private final String bournemouth = "shirts\\bournemouth.jpg";
    private final String brentford = "shirts\\brentford.jpg";
    private final String brighton = "shirts\\brighton.jpg";
    private final String chelsea = "shirts\\chelsea.jpg";
    private final String crystalPalace = "shirts\\crystalPalace.jpg";
    private final String everton = "shirts\\everton.jpg";
    private final String fulham = "shirts\\fulham.jpg";
    private final String leeds = "shirts\\leeds.jpg";
    private final String leicester = "shirts\\leicester.jpg";
    private final String liverpool = "shirts\\liverpool.jpg";
    private final String manchesterCity = "shirts\\manchesterCity.jpg";
    private final String manchesterUnited = "shirts\\manchesterUnited.jpg";
    private final String newcastle = "shirts\\newcastle.jpg";
    private final String nottingham = "shirts\\nottingham.jpg";
    private final String southampton = "shirts\\southampton.jpg";
    private final String tottenham = "shirts\\tottenham.jpg";
    private final String westHam = "shirts\\westHam.jpg";
    private final String wolverhampton = "shirts\\wolverhampton.jpg";

    public JComponent getImage(String team){
        ImageIcon image = null;

        switch (team){
            case "Arsenal"-> image = new ImageIcon(this.arsenal);
            case "Aston Villa"-> image = new ImageIcon(this.astonVilla);
            case "Bournemouth"-> image = new ImageIcon(this.bournemouth);
            case "Brentford"-> image = new ImageIcon(this.brentford);
            case "Brighton"-> image = new ImageIcon(this.brighton);
            case "Chelsea"-> image = new ImageIcon(this.chelsea);
            case "Crystal Palace"-> image = new ImageIcon(this.crystalPalace);
            case "Everton"-> image = new ImageIcon(this.everton);
            case "Fulham"-> image = new ImageIcon(this.fulham);
            case "Leeds United"-> image = new ImageIcon(this.leeds);
            case "Leicester City"-> image = new ImageIcon(this.leicester);
            case "Liverpool"-> image = new ImageIcon(this.liverpool);
            case "Manchester City"-> image=new ImageIcon(this.manchesterCity);
            case "Manchester Utd"-> image=new ImageIcon(this.manchesterUnited);
            case "Newcastle Utd"-> image=new ImageIcon(this.newcastle);
            case "Nott'ham Forest"-> image=new ImageIcon(this.nottingham);
            case "Southampton"-> image=new ImageIcon(this.southampton);
            case "Tottenham"-> image=new ImageIcon(this.tottenham);
            case "West Ham"-> image=new ImageIcon(this.westHam);
            case "Wolves"-> image=new ImageIcon(this.wolverhampton);
        }

        assert image != null;
        Image originalImage = image.getImage();
        Image imageNewSize = originalImage.getScaledInstance(45,60, Image.SCALE_DEFAULT);
        ImageIcon ny = new ImageIcon(imageNewSize);

        return new JLabel(ny);
    }




}
