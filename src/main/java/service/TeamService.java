package service;

import db.DBConnection;
import dto.TeamRepDTO;
import model.stadium.Stadium;
import model.stadium.StadiumDao;
import model.team.Team;
import model.team.TeamDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TeamService {
    public void 팀등록(Integer stadiumId, String name) {
        Connection connection = DBConnection.getInstance();
        TeamDao teamDao = new TeamDao(connection);
        try{
            teamDao.insert(stadiumId, name);
        } catch(
                SQLException e)
        {
            System.out.println("전송 실패: " + e.getMessage());
        }
    }

    public void 팀목록(){
        Connection connection = DBConnection.getInstance();
        TeamDao teamDao = new TeamDao(connection);
        try {
            List<TeamRepDTO> teamList = teamDao.getJoinTable();
            System.out.println(teamList);
        } catch (SQLException e) {
            System.out.println("조회 실패 :" + e.getMessage());
        }
    }
}
