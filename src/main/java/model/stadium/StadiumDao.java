package model.stadium;

import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Getter
public class StadiumDao {
    private Connection connection;

    public StadiumDao(Connection connection){
        this.connection = connection;
    }
    public void createStadium(String name) throws SQLException {
        String query = "INSERT INTO stadium (name, createdat) values (?, now());";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
    }

}
