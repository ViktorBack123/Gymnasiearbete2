package goalies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class insertGoalies {
    public static void main(String[] args) throws SQLException, IOException {
        new insertGoalies();
    }
    public insertGoalies() throws IOException, SQLException {
        // Behövs det här
        //FileReader fileReader = new FileReader("J:\\Min enhet\\Programmering\\GyA\\sportsref.csv");
        FileReader fileReader = new FileReader("J:\\Min enhet\\Programmering\\GyA\\goalies.txt");
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        row = bufferedReader.readLine();
        row = bufferedReader.readLine();
        String[] arr;
        int i = 1; // behövs detta

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ArrayList<String> d = new ArrayList<>(); // behövs detta

        while (row!=null) {
            arr=row.split(",");
            arr[1] = arr[1].replace("'","''");
            arr[4] = arr[4].replace("'","''");
            arr[9] = arr[9].replaceAll(",","");
            arr[9] = arr[9].replaceAll("\\.","");

            /*  i arr:

                1. name
                4. team
                3. position
                7. MP
                8. starts
                9. minutes
                11. goals against
                13. shots on target against
                14. saves
                15. save%
                19. clean sheets
                22. penalties against
                23. penaly saves
             */

            System.out.println("insert into goalkeepers(name, " +
                    "position, "+
                    "team, "+
                    "Matches_played, "+
                    "Starts, "+
                    "minutes, "+
                    "goals_against, "+
                    "SoT_against, "+
                    "saves, "+
                    "save_percent, "+
                    "clean_sheets, "+
                    "penalties_against, "+
                    "savePercent_penalties)" +
                    "values(" +
                    "'" + arr[1] + "', "+
                    "'" + arr[4] + "', "+
                    "'" + arr[3] + "', "+
                    arr[7] + ", "+
                    arr[8] + ", "+
                    arr[9] + ", "+
                    arr[11] + ", "+
                    arr[13] + ", "+
                    arr[14] + ", "+
                    arr[15] + ", "+
                    arr[19] + ", "+
                    arr[22] + ", "+
                    arr[23] + ")");

            statement.executeUpdate("insert into goalkeepers(name, " +
                    "position, "+
                    "team, "+
                    "Matches_played, "+
                    "Starts, "+
                    "minutes, "+
                    "goals_against, "+
                    "SoT_against, "+
                    "saves, "+
                    "save_percent, "+
                    "clean_sheets, "+
                    "penalties_against, "+
                    "savePercent_penalties)" +
                    "values(" +
                    "'" + arr[1] + "', "+
                    "'" + arr[4] + "', "+
                    "'" + arr[3] + "', "+
                    arr[7] + ", "+
                    arr[8] + ", "+
                    arr[9] + ", "+
                    arr[11] + ", "+
                    arr[13] + ", "+
                    arr[14] + ", "+
                    arr[15] + ", "+
                    arr[19] + ", "+
                    arr[22] + ", "+
                    arr[23] + ")");

            row=bufferedReader.readLine();
            i++;
        }
    }
}
