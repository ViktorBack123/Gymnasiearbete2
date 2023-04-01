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

public class PlayingTime extends Thread{
    @Override
    public void run() {

    String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

    try {


        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String file = "J:\\Min enhet\\Programmering\\GyA\\playingTime.txt";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        //row = bufferedReader.readLine();
        //row = bufferedReader.readLine();

        String[] arr;
        int i=1;

        while (row!=null) {
            arr=row.split(",");
            if(Objects.equals(arr[8], ""))arr[9]="0";
            if(Objects.equals(arr[10], ""))arr[20]="0";
            if(Objects.equals(arr[13], ""))arr[25]="0";

            /*
            Min_per_match 9
            goalsAllowed 20
            xGA 25
            */

            System.out.println("UPDATE players SET (" +
                    "minutesPerMatch, " + "goalsAllowed, " + "xGA" +
                    ") = (" + arr[9] + ", " + arr[20] + ", " + arr[25] + ") WHERE rowid = " + i);


            /*statement.executeUpdate("UPDATE players SET (" +
                    "Minutes_Per_Match, " + "goalsAllowed, " + "xGA" +
                    ") = (" + arr[9] + ", " + arr[20] + ", " + arr[25] + ") WHERE rowid = " + i);

             */



            row=bufferedReader.readLine();
            i++;
        }
    }catch (SQLException|IOException e){
        System.out.println(e);
    }
    }
}
