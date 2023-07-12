package model.out_player;

import lombok.Getter;
import model.player.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OutPlayerDao {
    private Connection connection;

    public OutPlayerDao(Connection connection) {
        this.connection = connection;
    }

    // 퇴출 선수 등록
    public OutPlayer insert(int playerId, String reason) throws SQLException {
        String query = "INSERT INTO out_player (player_id, reason, created_at) values(?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.setString(2, reason);
            int result = statement.executeUpdate();
            if (result == 1) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
        return null;
    }

    // 방출선수 전체 조회
    public List<OutPlayer> getAllOutPlayers() throws SQLException {
        List<OutPlayer> outPlayers = new ArrayList<>();
        String query = "SELECT * FROM out_player";
        try (Statement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    OutPlayer outPlayer = buildOutPlayerFromResultSet(resultSet);
                    outPlayers.add(outPlayer);
                }
            }
        }
        return outPlayers;
    }

    private OutPlayer buildOutPlayerFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int playerId = resultSet.getInt("player_id");
        String reason = resultSet.getString("reason");
        Timestamp createdAt = resultSet.getTimestamp("created_at");

        return OutPlayer.builder()
                .id(id)
                .playerId(playerId)
                .reason(reason)
                .createdAt(createdAt)
                .build();
    }
}
