package service;

import db.DBConnection;
import model.out_player.OutPlayer;
import model.out_player.OutPlayerDao;
import model.player.Player;
import model.player.PlayerDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OutPlayerService {
    public void createOutPlayer(int playerId, String reason) {
        Connection connection = DBConnection.getInstance();
        OutPlayerDao outPlayerDao = new OutPlayerDao(connection);
        try{
            outPlayerDao.createOutPlayer(playerId, reason);
        } catch(
                SQLException e)
        {
            System.out.println("전송 실패: " + e.getMessage());
        }
    }

    public void getAllOutPlayers(){
        Connection connection = DBConnection.getInstance();
        OutPlayerDao outPlayerDao = new OutPlayerDao(connection);
        try {
            List<OutPlayer> outPlayerList = outPlayerDao.getAllOutPlayers();
            System.out.println(outPlayerList);
        } catch (SQLException e) {
            System.out.println("조회 실패 :" + e.getMessage());
        }
    }
}
