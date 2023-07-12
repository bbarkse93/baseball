package model.team;

import lombok.Getter;
import model.stadium.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TeamDao {
    private Connection connection;

    public TeamDao(Connection connection){
        this.connection = connection;
    }
    // 팀 등록
    public Team insert(Integer stadiumId, String name) throws SQLException {
        String query = "INSERT INTO team (stadium_id, name, created_at) values (?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stadiumId);
            statement.setString(2, name);
            int result = statement.executeUpdate();
            if (result == 1){
                System.out.println("성공");
            }else {
                System.out.println("실패");
            }
        }
        return null;
    }

    // 팀 전체 조회
    public List<Team> getAllTeams() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM team";
        try (Statement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery(query)){
                while (resultSet.next()) {
                    Team team = buildTeamFromResultSet(resultSet);
                    teams.add(team);
                }
            }
        }
        return teams;
    }
    private Team buildTeamFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int stadiumId = resultSet.getInt("stadiumId");
        String name = resultSet.getString("name");
        Timestamp createdAt = resultSet.getTimestamp("created_at");

        return Team.builder()
                .id(id)
                .stadiumId(stadiumId)
                .name(name)
                .createdAt(createdAt)
                .build();
    }

    // 한 팀 조회
}
