package goalies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dropTable {
    public static void main(String[] args) throws SQLException {
        new dropTable();
    }
    public dropTable() throws SQLException {
        String url = "jdbc:sqlite:J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);  // sets timeout

        //statement.executeUpdate("drop table players");
        statement.executeUpdate("drop table goalkeepers");
    }
}
