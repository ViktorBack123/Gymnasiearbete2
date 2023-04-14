package sqlite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class StandardStats extends Thread{
    @Override
    public void run() {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        // String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel

        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String file = "J:\\Min enhet\\Programmering\\GyA\\standardStats.txt";
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader  =new BufferedReader(fileReader);
            String row = bufferedReader.readLine(); // behövs detta verkligen
            row = bufferedReader.readLine();
            row = bufferedReader.readLine();

            String[] arr;
            int i = 1;

            while (row != null) {
                arr = row.split(",");
                if (Objects.equals(arr[8], "")) arr[8]="0";
                if (Objects.equals(arr[10], "")) arr[12]="0";
                if (Objects.equals(arr[13], "")) arr[13]="0";

                System.out.println("UPDATE players SET (matchesPlayed," +
                        "starts," + "minutes," + "goals," + "assists," +
                        "penalties," + "yellows," + "reds," + "xG," +
                        "xAG," + "prgC," + "prgP," + "prgR) = (" +arr[7]+
                        "," + arr[8] + "," + arr[9] + "," + arr[11]+
                        "," + arr[12] + ","+arr[15] + ","+arr[17]+
                        "," + arr[18] +  ","+arr[19] + "," + arr[21]+
                        "," + arr[23] + "," +arr[24] + ","+arr[25]+") WHERE rowid = " + i);

                statement.executeUpdate("UPDATE players SET (matchesPlayed," +
                        "starts," + "minutes," + "goals," + "assists," +
                        "penalties," + "yellows," + "reds," + "xG," +
                        "xAG," + "prgC," + "prgP," + "prgR) = (" +arr[7]+
                        "," + arr[8] + "," +  arr[9] + "," + arr[11]+
                        "," + arr[12] + "," + arr[15] + ","+arr[17]+
                        "," + arr[18] +  "," + arr[19] + "," + arr[21]+
                        "," + arr[23] + "," + arr[24] + ","+arr[25]+") WHERE rowid = " + i);

                row=bufferedReader.readLine();
                i++;
            }
        } catch (SQLException | IOException e){
            System.out.println(e);
        }
    }
}
