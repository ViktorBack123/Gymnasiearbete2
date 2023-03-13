package sqlite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class insertPlayers {
    public static void main(String[] args) throws IOException, SQLException {
        FileReader fileReader = new FileReader("J:\\Min enhet\\Programmering\\GyA\\gymnasiearbeteexcel.csv");
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        row = bufferedReader.readLine();
        String[] arr;
        int i=1;

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";


        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ArrayList<String> d = new ArrayList<>();

        //statement.setQueryTimeout(60);

        String temp;
        while (row!=null) {
            arr=row.split(";");
            //System.out.println(i + ". namn: " + arr[0]+" URL: " + arr[1]+ " lag: " + arr[2]);
            arr[0] = arr[0].replace("'","''");
            statement.executeUpdate("insert into players(name,URL,team) values ('"+arr[0]+"',"+arr[1]+",'"+arr[2]+"')");
            System.out.println("insert into players(name,URL,team) values ('"+arr[0]+"',"+arr[1]+",'"+arr[2]+"')");
            row=bufferedReader.readLine();
            i++;
        }
    }
}
