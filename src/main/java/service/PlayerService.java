package service;

import db.DBConnection;
import dto.PositionRespDTO;
import model.player.Player;
import model.player.PlayerDao;
import model.stadium.Stadium;
import model.stadium.StadiumDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlayerService {
    Connection connection = DBConnection.getInstance();
    PlayerDao playerDao = new PlayerDao(connection);

    public void 선수등록(int teamId, String name, String position) {
        try{
            playerDao.insert(teamId, name, position);
        } catch(
                SQLException e)
        {
            System.out.println("전송 실패: " + e.getMessage());
        }
    }

    public void 선수목록(Integer teamId){
        try {
            List<Player> playerList = playerDao.getOneTeam(teamId);
        } catch (SQLException e) {
            System.out.println("조회 실패 :" + e.getMessage());
        }
    }

    public void 포지션별목록(){
        try {
            List<PositionRespDTO> respDTOS = playerDao.getJoinPosition();
        } catch (SQLException e) {
            System.out.println("조회 실패 :" + e.getMessage());
        }
    }

}
