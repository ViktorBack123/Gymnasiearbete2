package fpl.algorithms;

import java.sql.*;
import java.util.ArrayList;

public class VikAlgorithm {
    public static void main(String[] args) throws SQLException {
        new VikAlgorithm();
    }




    public VikAlgorithm() throws SQLException {
        ArrayList<String> list = new ArrayList<>();

        list.add("Matches_Played");
        list.add("starts");
        list.add("minutes");
        list.add("goals");
        list.add("assists");
        list.add("penalties");
        list.add("yellows");
        list.add("reds");
        list.add("xG");
        list.add("xAG");
        list.add("prgC");
        list.add("prgP");
        list.add("prgR");
        list.add("touches");
        list.add("touches_attacking_third");
        list.add("touches_attacking_box");
        list.add("minutes_per_match");
        list.add("goalsallowed");
        list.add("xGA");
        list.add("tackles");
        list.add("tacklesWon");
        list.add("defensive_errors");
        list.add("shortpasses_completed");
        list.add("shortpasses_percent");
        list.add("mediumpasses_completed");
        list.add("mediumpasses_percent");
        list.add("key_passes");
        list.add("passes_final_third");
        list.add("passes_box");

        ArrayList<Highest> parameters = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            parameters.add(new Highest(list.get(i)));
            parameters.get(i).print();
        }
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

        String sql = "SELECT * from players";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.print(rs.getString("name") + "|" + rs.getString("position")+"|");
            for (int i = 0; i < parameters.size(); i++) {
                System.out.print(rs.getString(list.get(i))+"|");
            }
            System.out.println();


        }


    }

}
