package sqlite;

import java.sql.*;

public class createTable {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        //DriverManager.getConnection("J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db");


        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);  // sets timeout

        statement.executeUpdate("create table players(name text, URL integer, team text)");

        ResultSet rs = statement.executeQuery("select * from fromexcel");
    }
}

