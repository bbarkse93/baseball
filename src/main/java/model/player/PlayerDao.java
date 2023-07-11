package model.player;

import lombok.Getter;
import model.stadium.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayerDao {

    private Connection connection;
    public PlayerDao(Connection connection){
        this.connection = connection;
    }

    // 선수 등록
    public Player createPlayer(int teamId, String name, String position) throws SQLException {
        String query = "INSERT INTO player (team_id, name, position, created_at) values(?, ?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            statement.setString(2, name);
            statement.setString(3, position);
            statement.executeUpdate();
        }
        return null;
    }

    // 선수 전체 조회
    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM player";
        try (Statement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery(query)){
                while (resultSet.next()) {
                    Player player = buildPlayerFromResultSet(resultSet);
                    players.add(player);
                }
            }
        }
        return players;
    }
    private Player buildPlayerFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int teamId = resultSet.getInt("team_id");
        String name = resultSet.getString("name");
        Timestamp createdAt = resultSet.getTimestamp("created_at");

        return Player.builder()
                .id(id)
                .teamId(teamId)
                .name(name)
                .createdAt(createdAt)
                .build();
    }

    // 선수 한 명 조회
}
