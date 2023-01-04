import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Grafik {
    JFrame frame = new JFrame();

    JButton[] players = new JButton[15];

    JTextField[] textFields = new JTextField[15];

    JPanel panel = new JPanel();


    public Grafik() {
        // Fönstret:
        frame.setLayout(new FlowLayout());
        frame.setSize(frame.getMaximumSize());
        frame.getContentPane().setBackground(new Color(31, 183, 13, 180));

        // Spelarna:
        for (int i = 0; i < 15; i++) {
            players[i] = new JButton();
            players[i].setPreferredSize(new Dimension(100, 100));
            players[i].setBorder(new LineBorder(Color.BLACK,8));
            frame.add(players[i]);
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Grafik();
    }
}
