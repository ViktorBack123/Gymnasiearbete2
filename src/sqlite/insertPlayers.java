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

public class insertPlayers {
    public static void main(String[] args) throws IOException, SQLException {
        new insertPlayers();
    }

    public insertPlayers() throws IOException, SQLException {
        //FileReader fileReader = new FileReader("J:\\Min enhet\\Programmering\\GyA\\sportsref.csv");
        FileReader fileReader = new FileReader("J:\\Min enhet\\Programmering\\GyA\\test.txt");
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        row=bufferedReader.readLine();
        row=bufferedReader.readLine();
        row=bufferedReader.readLine();
        row=bufferedReader.readLine();
        //row = bufferedReader.readLine();
        String[] arr;
        int i=1;

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";


        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ArrayList<String> d = new ArrayList<>();

        //statement.setQueryTimeout(60);


        while (row!=null) {
            arr=row.split(",");
            arr[1] = arr[1].replace("'","''");
            arr[4] = arr[4].replace("'","''");
            arr[9] = arr[9].replaceAll(",","");
            arr[9] = arr[9].replaceAll("\\.","");
            //statement.executeUpdate("insert into players(name,URL,team) values ('"+arr[0]+"',"+arr[1]+",'"+arr[2]+"')");
            System.out.print(i+". ");
            System.out.println(arr[1]);
           statement.executeUpdate(("insert into playersExtra(" +
                            "name," +
                            "team," +
                            "Matches_Played," +
                            "Starts," +
                            "minutes," +
                            "goals," +
                            "assists," +
                            "GnA," +
                            "nonPenaltiesG," +
                            "penalties," +
                            "yellows," +
                            "reds," +
                            "xG," +
                            "npxg," +
                            "xag," +
                            "prgc," +
                            "prgp," +
                            "prgr)values('"+arr[1]+
                    "','"+arr[4]+
                    "',"+arr[7]+
                    ","+arr[8]+
                    ","+arr[9]+
                    ","+arr[11]+
                    ","+arr[12]+
                    ","+arr[13]+
                    ","+arr[14]+
                    ","+arr[15]+
                    ","+arr[17]+
                    ","+arr[18]+
                    ","+arr[19]+
                    ","+arr[20]+
                    ","+arr[21]+
                    ","+arr[23]+
                    ","+arr[24]+
                    ","+arr[25]+")"));


            System.out.println("insert into playersExtra(" +
                    "name," +
                    "team," +
                    "Matches_Played," +
                    "Starts," +
                    "minutes," +
                    "goals," +
                    "assists," +
                    "GnA," +
                    "nonPenaltiesG," +
                    "penalties," +
                    "yellows," +
                    "reds," +
                    "xG," +
                    "npxg," +
                    "xag," +
                    "prgc," +
                    "prgp," +
                    "prgr)values('"+arr[1]+
                    "','"+arr[4]+
                    "',"+arr[7]+
                    ","+arr[8]+
                    ","+arr[9]+
                    ","+arr[11]+
                    ","+arr[12]+
                    ","+arr[13]+
                    ","+arr[14]+
                    ","+arr[15]+
                    ","+arr[17]+
                    ","+arr[18]+
                    ","+arr[19]+
                    ","+arr[20]+
                    ","+arr[21]+
                    ","+arr[23]+
                    ","+arr[24]+
                    ","+arr[25]+")");


            row=bufferedReader.readLine();
            i++;
        }
    }
}
