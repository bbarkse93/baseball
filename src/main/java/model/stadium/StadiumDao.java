package model.stadium;

import lombok.Builder;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class StadiumDao {
    private Connection connection;

    public StadiumDao(Connection connection){
        this.connection = connection;
    }

    // 경기장 등록(insert)

    public Stadium createStadium(String name) throws SQLException {
        String query = "INSERT INTO stadium (name, created_at) values (?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
        return null;
    }

    // 경기장 전체 조회
    public List<Stadium> getAllStadiums() throws SQLException {
        List<Stadium> stadiums = new ArrayList<>();
        String query = "SELECT * FROM stadium";
        try (Statement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery(query)){
                while (resultSet.next()) {
                    Stadium stadium = buildStadiumFromResultSet(resultSet);
                    stadiums.add(stadium);
                }
            }
        }
        return stadiums;
    }
    private Stadium buildStadiumFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Timestamp createdAt = resultSet.getTimestamp("created_at");

        return Stadium.builder()
                .id(id)
                .name(name)
                .createdAt(createdAt)
                .build();
    }

    // 경기장 한 곳 조회


}
