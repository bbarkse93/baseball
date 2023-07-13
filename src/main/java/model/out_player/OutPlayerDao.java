package model.out_player;

import dto.OutPlayerRespDTO;
import dto.TeamRespDTO;
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
        Integer id = resultSet.getInt("id");
        Integer playerId = resultSet.getInt("player_id");
        String reason = resultSet.getString("reason");
        Timestamp createdAt = resultSet.getTimestamp("created_at");

        return OutPlayer.builder()
                .id(id)
                .playerId(playerId)
                .reason(reason)
                .createdAt(createdAt)
                .build();
    }

    // 방출선수 조회 WITH선수
    public List<OutPlayerRespDTO> getJoinPlayer() throws SQLException {
        List<OutPlayerRespDTO> outPlayers = new ArrayList<>();
        String query = "SELECT p.id, p.name, p.position, o.reason, o.created_at AS 퇴출일\n" +
                "FROM out_player o RIGHT OUTER JOIN player p\n" +
                "ON o.player_id = p.id";
        try (Statement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery(query)){
                while (resultSet.next()) {
                    OutPlayerRespDTO outPlayerRespDTO = buildgetJoinPlayerResultSet(resultSet);
                    outPlayers.add(outPlayerRespDTO);
                    System.out.print("id: " + outPlayerRespDTO.getId() + " ");
                    System.out.print("name: " + outPlayerRespDTO.getName() + " ");
                    System.out.print("position: " + outPlayerRespDTO.getPosition() + " ");
                    if (outPlayerRespDTO.getReason() != null || outPlayerRespDTO.getCreatedAt() != null) {
                        System.out.print("이유: " + outPlayerRespDTO.getReason() + " ");
                        System.out.print("퇴출일: " + outPlayerRespDTO.getCreatedAt() + " ");
                    }
                    System.out.println("");
                }
            }
        }
        return outPlayers;
    }

    private OutPlayerRespDTO buildgetJoinPlayerResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String position = resultSet.getNString("position");
        String reason = resultSet.getString("reason");
        Timestamp createdAt = resultSet.getTimestamp("퇴출일");

        return OutPlayerRespDTO.builder()
                .id(id)
                .name(name)
                .position(position)
                .reason(reason)
                .createdAt(createdAt)
                .build();
    }
}
