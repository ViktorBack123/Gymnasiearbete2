package goalies;

import java.sql.*;

public class GoalkeeperHighest {
    double highest;
    double lowest;
    String parameter;

    public GoalkeeperHighest(String parameter) throws SQLException {
        this.parameter = parameter;

        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db"; // Viktor
        //String url = "jdbc:sqlite:J:\\Min enhet\\GyA\\databases\\gymnasiearbete.db"; // Axel
        Connection connection = DriverManager.getConnection(url);

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);  // sets timeout

        ResultSet rs = statement.executeQuery("select MAX(" + parameter + ") from goalkeepers");

        highest= rs.getDouble(1);

        rs = statement.executeQuery("select MIN(" + parameter + ") from goalkeepers");
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
    } // är den nödvändig

    public void print(){
        System.out.println("stat: " + parameter + ", highest: " + highest + ", lowest: " + lowest);
    } // är denna nödvändig
}

