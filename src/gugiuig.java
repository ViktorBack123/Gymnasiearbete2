import java.sql.DriverManager;
import java.sql.SQLException;

public class gugiuig {
    public static void main(String[] args) throws SQLException {
        String url = "J:\\Min enhet\\Programmering\\GyA\\GyA IntJ\\Gymnasiearbete\\databases\\gymnasiearbete.db";
        DriverManager.getConnection(url);

    }
}
