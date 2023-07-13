package service;

import db.DBConnection;
import model.stadium.Stadium;
import model.stadium.StadiumDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StadiumService {

    public void 야구장등록(String name) {
        Connection connection = DBConnection.getInstance();
        StadiumDao stadiumDao = new StadiumDao(connection);
        try{
            stadiumDao.insert(name);
        } catch(SQLException e)
        {
            System.out.println("전송 실패: " + e.getMessage());
        }
    }

    public void 야구장목록(){
        Connection connection = DBConnection.getInstance();
        StadiumDao stadiumDao = new StadiumDao(connection);
        try {
            List<Stadium> stadiumList = stadiumDao.getAllStadiums();
            System.out.println(stadiumList);
        } catch (SQLException e) {
            System.out.println("조회 실패 :" + e.getMessage());
        }
    }
}
