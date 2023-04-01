package sqlite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class defensive extends Thread{

    @Override
    public void run() {

    String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

    try {

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String file = "J:\\Min enhet\\Programmering\\GyA\\defensive.txt";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        row = bufferedReader.readLine();
        row = bufferedReader.readLine();

        String[] arr;
        int i=1;

        while (row!=null) {
            arr=row.split(",");
            /*
            tackles 8
            tackles won 9
            defensive_errors 23
             */

            statement.executeUpdate("UPDATE players SET (defensiveErrors,tacklesWon,tackles) = (" + arr[23] + ", " + arr[9] + ", " + arr[8] + ") WHERE rowid = " + i);

            System.out.println("UPDATE players SET (defensiveErrors,tacklesWon,tackles) = (" + arr[23] + ", " + arr[9] + ", " + arr[8] + ") WHERE rowid = " + i);

            row=bufferedReader.readLine();
            i++;
        }
    }catch (SQLException|IOException e){
        System.out.println(e);
        }
    }
}
