package service;

import db.DBConnection;
import dto.TeamRespDTO;
import model.team.TeamDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TeamService {
    Connection connection = DBConnection.getInstance();
    TeamDao teamDao = new TeamDao(connection);

    public void 팀등록(Integer stadiumId, String name) {
        try{
            teamDao.insert(stadiumId, name);
        } catch(
                SQLException e)
        {
            System.out.println("전송 실패: " + e.getMessage());
        }
    }

    public void 팀목록(){
        try {
            List<TeamRespDTO> teamList = teamDao.getJoinTable();
        } catch (SQLException e) {
            System.out.println("조회 실패 :" + e.getMessage());
        }
    }


}
