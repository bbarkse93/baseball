import db.DBConnection;
import model.stadium.StadiumDao;
import org.json.simple.JSONObject;
import service.OutPlayerService;
import service.PlayerService;
import service.StadiumService;
import service.TeamService;


import java.sql.Connection;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {
        StadiumService stadiumService = new StadiumService();
        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        OutPlayerService outPlayerService = new OutPlayerService();

        //        Scanner sc = new Scanner(System.in);
//        System.out.println("어떤 기능을 요청하시겠습니까?");
//        String str = sc.next();
        String str = "포지션별목록";


        String[] params = str.split("\\?");
        String action = params[0];

//

        // 3.1 야구장등록?name=잠실야구장
        if (action.equals("야구장등록")) {
            String paramString = params[1];
            String[] val1 = paramString.split("\\=");

            stadiumService.야구장등록(val1[1]);
        }

        // 3.2 야구장목록
        if (action.equals("야구장목록")) {
            stadiumService.야구장목록();
        }

        // 3.3 팀등록?stadiumId=1&name=NC
        if (action.equals("팀등록")) {
            String paramString = params[1];
            String[] title = paramString.split("\\&");
            String teamId = title[0];

            String[] val1 = teamId.split("\\=");
            Integer.parseInt(val1[1]);
            String name = title[1];

            String[] val2 = name.split("\\=");

            teamService.팀등록(Integer.valueOf(val1[1]), val2[1]);
        }

        // 3.4 팀목록
        if (action.equals("팀목록")){

            teamService.팀목록();
        }

        // 3.5 선수등록?teamId=1&name=이대호&position=1루수
        if (action.equals("선수등록")){
            String paramString = params[1];
            String[] title = paramString.split("\\&");
            String teamId = title[0];

            String[] val1 = teamId.split("\\=");
            Integer.parseInt(val1[1]);

            String name = title[1];
            String[] val2 = name.split("\\=");

            String position = title[2];
            String[] val3 = position.split("\\=");

            playerService.선수등록(Integer.valueOf(val1[1]), val2[1], val3[1]);
        }

        // 3.6 선수목록?teamId=1
        if (action.equals("선수목록")){
            String paramString = params[1];
            String[] val1 = paramString.split("\\=");

            playerService.선수목록(Integer.valueOf(val1[1]));
        }
//
       // 3.7 퇴출등록?playerId=1&reason=도박
        if (action.equals("퇴출등록")) {
            String paramString = params[1];
            String[] title = paramString.split("\\&");
            String teamId = title[0];

            String[] val1 = teamId.split("\\=");
            Integer.parseInt(val1[1]);
            String name = title[1];

            String[] val2 = name.split("\\=");
            outPlayerService.퇴출등록(Integer.valueOf(val1[1]), val2[1]);
        }
//
        // 3.8 퇴출목록
        if (action.equals("퇴출목록")){

            outPlayerService.퇴출목록();
        }

        // 3.10 포지션별목록
        if (action.equals("포지션별목록")){

            playerService.포지션별목록();
        }

    }
}


