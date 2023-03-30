package sqlite;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateDatabase {
    public static void main(String[] args) throws SQLException, IOException {
        new UpdateDatabase();
    }

    public UpdateDatabase() throws SQLException, IOException {
        StandardStats standardStats = new StandardStats();
        Possession possession =new Possession();
        PlayingTime playingTime = new PlayingTime();
        Passing passing = new Passing();
        defensive defensive = new defensive();
        standardStats.start();
        possession.start();
        playingTime.start();
        passing.start();
        defensive.start();
    }

}
