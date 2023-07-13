package service;

import db.DBConnection;
import dto.OutPlayerRespDTO;
import model.out_player.OutPlayer;
import model.out_player.OutPlayerDao;
import model.player.Player;
import model.player.PlayerDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OutPlayerService {
    Connection connection = DBConnection.getInstance();
    OutPlayerDao outPlayerDao = new OutPlayerDao(connection);

    public void 퇴출등록(int playerId, String reason) {
        Connection connection = DBConnection.getInstance();
        OutPlayerDao outPlayerDao = new OutPlayerDao(connection);
        PlayerDao playerDao = new PlayerDao(connection);
        try {
            playerDao.update(playerId);
            outPlayerDao.insert(playerId, reason);
        } catch (Exception e) {
        }
    }

    public void 퇴출목록(){
        try {
            List<OutPlayerRespDTO> outPlayers = outPlayerDao.getJoinPlayer();
        } catch (SQLException e) {
            System.out.println("조회 실패 :" + e.getMessage());
        }
    }
}
