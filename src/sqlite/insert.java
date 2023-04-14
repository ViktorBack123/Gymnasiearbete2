package sqlite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class insert {

    public static void main(String[] args) throws IOException, SQLException {
        new insert();
    }

    public insert() throws IOException, SQLException {
        String file = "J:\\Min enhet\\Programmering\\GyA\\standardStats.txt";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        row = bufferedReader.readLine();
        row=bufferedReader.readLine();
        String[] arr;

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        // String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();

        while (row != null) {
            arr = row.split(",");
            arr[1] = arr[1].replace("'","''");
            arr[4] = arr[4].replace("'","''");
            arr[9] = arr[9].replaceAll(",","");
            arr[9] = arr[9].replaceAll("\\.","");
            statement.executeUpdate(("insert into players(" +
                    "name," +
                    "position," +
                    "team," +
                    "matchesPlayed," +
                    "starts," +
                    "minutes," +
                    "goals," +
                    "assists," +
                    "penalties," +
                    "yellows," +
                    "reds," +
                    "xG," +
                    "xAG," +
                    "prgC," +
                    "prgP," +
                    "prgR)values('"+arr[1]+
                    "','"+arr[3]+
                    "','"+arr[4]+
                    "',"+arr[7]+
                    ","+arr[8]+
                    ","+arr[9]+
                    ","+arr[11]+
                    ","+arr[12]+
                    ","+arr[15]+
                    ","+arr[17]+
                    ","+arr[18]+
                    ","+arr[19]+
                    ","+arr[21]+
                    ","+arr[23]+
                    ","+arr[24]+
                    ","+arr[25]+")"));

            System.out.println("insert into players(" +
                    "name," +
                    "position," +
                    "team," +
                    "matchesPlayed," +
                    "starts," +
                    "minutes," +
                    "goals," +
                    "assists," +
                    "penalties," +
                    "yellows," +
                    "reds," +
                    "xG," +
                    "xAG," +
                    "prgC," +
                    "prgP," +
                    "prgR)values('"+arr[1]+
                    "','"+arr[3]+
                    "','"+arr[4]+
                    "',"+arr[7]+
                    ","+arr[8]+
                    ","+arr[9]+
                    ","+arr[11]+
                    ","+arr[12]+
                    ","+arr[15]+
                    ","+arr[17]+
                    ","+arr[18]+
                    ","+arr[19]+
                    ","+arr[21]+
                    ","+arr[23]+
                    ","+arr[24]+
                    ","+arr[25]+")");

            row = bufferedReader.readLine();
        }
    }
}
