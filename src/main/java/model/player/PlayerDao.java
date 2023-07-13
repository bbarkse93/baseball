package model.player;

import dto.OutPlayerRespDTO;
import dto.PositionRespDTO;
import lombok.Getter;
import model.stadium.Stadium;
import model.team.Team;

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
    public Player insert(Integer teamId, String name, String position) throws SQLException {
        String query = "INSERT INTO player (team_id, name, position, created_at) values(?, ?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            statement.setString(2, name);
            statement.setString(3, position);
            int result = statement.executeUpdate();
            if (result == 1){
                System.out.println("성공");
            }else {
                System.out.println("실패");
            }
        }
        return null;
    }

//     선수 전체 조회
    public List<Player> selectAll() throws SQLException {
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

    //팀 별 선수 조회
    public List<Player> getOneTeam(Integer teamId) throws SQLException {
        String query = "select id, name, position, created_at from player where team_id = ? ORDER BY id ASC";
        List<Player> playerList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Player player = buildPlayerFromResultSet(resultSet);
                    playerList.add(player);
                    System.out.print("id: " + player.getId() + " ");
                    System.out.print("Name: " + player.getName() + " ");
                    System.out.print("Position: " + player.getPosition() + " ");
                    System.out.println("createdAt: " + player.getCreatedAt());
                    System.out.println("");
                }
            }
        }
        return playerList;
    }

    private Player buildPlayerFromResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String position = resultSet.getString("position");
        Timestamp createdAt = resultSet.getTimestamp("created_at");

        return Player.builder()
                .id(id)
                .teamId(null)
                .name(name)
                .position(position)
                .createdAt(createdAt)
                .build();
    }

    // 선수 한 명 수정
    public void update(Integer id) throws SQLException{
        String query = "UPDATE player SET team_id = null WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // 포지션별 목록
    public List<PositionRespDTO> getJoinPosition() throws SQLException {
        List<PositionRespDTO> positionList = new ArrayList<>();
        String query = "SELECT position,\n" +
                "    MAX(CASE WHEN team_name = '롯데' THEN player_name END) AS 롯데,\n" +
                "    MAX(CASE WHEN team_name = '기아' THEN player_name END) AS 기아,\n" +
                "    MAX(CASE WHEN team_name = '삼성' THEN player_name END) AS 삼성,\n" +
                "    MAX(CASE WHEN team_name = 'LG' THEN player_name END) AS LG,\n" +
                "    MAX(CASE WHEN team_name = 'NC' THEN player_name END) AS NC,\n" +
                "    MAX(CASE WHEN team_name = 'KIA' THEN player_name END) AS KIA,\n" +
                "    MAX(CASE WHEN team_name = 'SK' THEN player_name END) AS SK,\n" +
                "    MAX(CASE WHEN team_name = '한화' THEN player_name END) AS 한화,\n" +
                "    MAX(CASE WHEN team_name = 'KT' THEN player_name END) AS KT\n" +
                "FROM player p_name \n" +
                "INNER JOIN team t_name ON t.id = p.team_id\n" +
                "GROUP BY position";
        try (Statement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery(query)){
                while (resultSet.next()) {
                    PositionRespDTO positionRespDTO = buildgetJoinPositionResultSet(resultSet);
                    positionList.add(positionRespDTO);
                    System.out.println(positionRespDTO);
                }
            }
        }
        return positionList;
    }

    private PositionRespDTO buildgetJoinPositionResultSet(ResultSet resultSet) throws SQLException {
        String position = resultSet.getString("position");

        return PositionRespDTO.builder()
                .position(position)
                .build();

    }
}
