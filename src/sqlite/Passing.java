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

public class Passing extends Thread{

    @Override
    public void run() {

        try {

    String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String file = "J:\\Min enhet\\Programmering\\GyA\\passing.txt";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        row = bufferedReader.readLine();
        row = bufferedReader.readLine();

        String[] arr;
        int i=1;

        while (row!=null) {
            arr=row.split(",");
            if(Objects.equals(arr[8], ""))arr[8]="0";
            if(Objects.equals(arr[10], ""))arr[10]="0";
            if(Objects.equals(arr[13], ""))arr[13]="0";
            if(Objects.equals(arr[15], ""))arr[15]="0";
            if(Objects.equals(arr[26], ""))arr[26]="0";
            if(Objects.equals(arr[27], ""))arr[27]="0";
            if(Objects.equals(arr[28], ""))arr[28]="0";

            /*
            shortpasses_completed 8
            shortpasses_percent 10
            mediumpasses_completed 13
            mediumpasses_percent 15
            key_passes 26
            passes_final_third 27
            passes_box 28
             */
            System.out.println("UPDATE players SET (" +
                    "shortPasses_completed, " +
                    "shortPasses_percent, " +
                    "mediumPasses_completed, " +
                    "mediumPasses_percent, " +
                    "key_passes, " +
                    "passes_final_third, " +
                    "passes_box" +
                    ") = (" + arr[8] + ", " + arr[10] + ", " + arr[13] +
                    ", " + arr[15] + ", " + arr[26] + ", " + arr[27] +
                    ", " + arr[28] + ") WHERE rowid = " + i);

            statement.executeUpdate("UPDATE players SET (" +
                    "shortPasses_completed, " +
                    "shortPasses_percent, " +
                    "mediumPasses_completed, " +
                    "mediumPasses_percent, " +
                    "key_passes, " +
                    "passes_final_third, " +
                    "passes_box" +
                    ") = (" + arr[8] + ", " + arr[10] + ", " + arr[13] +
                    ", " + arr[15] + ", " + arr[26] + ", " + arr[27] +
                    ", " + arr[28] + ") WHERE rowid = " + i);





            row=bufferedReader.readLine();
            i++;
        }
        }catch (SQLException|IOException e){
            System.out.println(e);
        }
    }
}
