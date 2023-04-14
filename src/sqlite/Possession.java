package sqlite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;

public class Possession extends Thread{

    @Override
    public void run() {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        // String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel

        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String file = "J:\\Min enhet\\Programmering\\GyA\\possession.txt";
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader  =new BufferedReader(fileReader);
            String row = bufferedReader.readLine();
            row = bufferedReader.readLine();
            row = bufferedReader.readLine();

            String[] arr;
            int i = 1;

            while (row != null) {
                arr = row.split(",");
                if (Objects.equals(arr[8], "")) arr[8]="0";
                if (Objects.equals(arr[10], "")) arr[12]="0";
                if (Objects.equals(arr[13], "")) arr[13]="0";

            System.out.println("UPDATE players SET (" +
                    "touches, " + "touchesAttackingThird, " + "touchesAttackingBox" +
                    ") = (" + arr[8] + ", " + arr[12] + ", " + arr[13] + ") WHERE rowid = " + i);


            statement.executeUpdate("UPDATE players SET (" +
                    "touches, " + "touchesAttackingThird, " + "touchesAttackingBox" +
                    ") = (" + arr[8] + ", " + arr[12] + ", " + arr[13] + ") WHERE rowid = " + i);

            row = bufferedReader.readLine();
            i++;
        }
        }catch (SQLException | IOException e){
            System.out.println(e.getMessage());
        }

    }
}
