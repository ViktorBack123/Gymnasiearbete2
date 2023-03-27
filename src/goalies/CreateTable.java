package goalies;

import java.sql.*;

public class CreateTable {
    public static void main(String[] args) throws SQLException {
        new CreateTable();
    }

    public CreateTable() throws SQLException {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);  // sets timeout


        statement.executeUpdate("create table goalkeepers(" +
                "name TEXT," +
                "team TEXT," +
                "position TEXT," +
                "Matches_Played INTEGER," +
                "Starts INTEGER," +
                "minutes INTEGER," +
                "goals_against INTEGER," +
                "SoT_against INTEGER," +
                "saves INTEGER," +
                "save_percent DECIMAL," +
                "clean_sheets INTEGER," +
                "penalties_against INTEGER," +
                "savePercent_penalties DECIMAL)");

        ResultSet rs = statement.executeQuery("select * from fromexcel");



    }
}
