package service;

import db.DBConnection;
import model.player.Player;
import model.player.PlayerDao;
import model.stadium.Stadium;
import model.stadium.StadiumDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlayerService {

    public void createPlayer(int teamId, String name, String position) {
        Connection connection = DBConnection.getInstance();
        PlayerDao playerDao = new PlayerDao(connection);
        try{
            playerDao.createPlayer(teamId, name, position);
        } catch(
                SQLException e)
        {
            System.out.println("전송 실패: " + e.getMessage());
        }
    }

    public void getAllPlayers(){
        Connection connection = DBConnection.getInstance();
        PlayerDao playerDao = new PlayerDao(connection);
        try {
            List<Player> playerList = playerDao.getAllPlayers();
            System.out.println(playerList);
        } catch (SQLException e) {
            System.out.println("조회 실패 :" + e.getMessage());
        }
    }

}
