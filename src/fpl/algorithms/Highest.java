package fpl.algorithms;

import java.sql.*;

public class Highest {
    double highest;
    double lowest;
    String parameter;

    public Highest(String parameter) throws SQLException {
        this.parameter = parameter;

        //String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

        String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);  // sets timeout

        ResultSet rs = statement.executeQuery("select MAX(" + parameter + ") from players");

        highest= rs.getDouble(1);

        rs = statement.executeQuery("select MIN(" + parameter + ") from players");
        lowest= rs.getDouble(1);

        connection.close();
        statement.close();
        rs.close();
    }

    public double getHighest() {
        return highest;
    }

    public double getLowest() {
        return lowest;
    }

    public String getParameter() {
        return parameter;
    }

    public void print(){
        System.out.println("stat: " + parameter + ", highest: " + highest + ", lowest: " + lowest);
    }
}
