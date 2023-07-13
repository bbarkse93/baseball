import model.stadium.StadiumDao;
import org.json.simple.JSONObject;
import service.OutPlayerService;
import service.PlayerService;
import service.StadiumService;
import service.TeamService;


import javax.swing.*;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {

        StadiumService stadiumService = new StadiumService();
        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        OutPlayerService outPlayerService = new OutPlayerService();


        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 기능을 요청하시겠습니까?");
        String str = sc.next();
//        String str = "퇴출등록?playerId=3&reason=음주운전";
        String[] params = str.split("\\?");
        String action = params[0];


        System.out.println("액션 : " + action);


        // 3.1 야구장등록?name=잠실야구장
        if (action.equals("야구장등록")) {
            String body = params[1];
            System.out.println("바디 : " + body); // name=잠실야구장
            String name = body.split("=")[1];
            System.out.println("name : " + name);
            stadiumService.야구장등록(name);
        }


        // 3.2 야구장목록
        if (action.equals("야구장목록")) {

            stadiumService.야구장목록();

        }


        // 3.3 팀등록?stadiumId=1&name=NC
        if (action.equals("팀등록")) {
            String a = params[1];  // stadiumId=1&name=NC
            String b = a.split("&")[0]; //stadium=1
            String b1 = a.split("&")[1];
            String c = b1.split("=")[1];
            String c1 = b1.split("=")[1];
            teamService.팀등록(Integer.valueOf(c), c1);

        }



            //3.4 팀목록
        // 3.5 선수등록?teamId=1&name=이대호&position=1루수
        if (action.equals("선수등록")) {
            String aa = params[1];
            System.out.println("바디 : " + aa); //teamId=1&name=이대호&position=1루수
            String[] bb = aa.split("&");

            for (int i = 0; i < bb.length; i++) {
                System.out.println("bb : " + bb[i]);
            }
        }

        // 3.6 선수목록?teamId=1


        // 3.7 퇴출등록?playerId=1&reason=도박
        if (action.equals("퇴출등록")) {
            String exitregi = params[1]; // playerId=1&reason=도박
            String exitregi2 =exitregi.split("&")[0]; //playerId=1
            String exitregi3 =exitregi.split("&")[1]; //reason=도박
            String exitregi4 = exitregi3.split("=")[1]; //도박
            String exitregi5 = exitregi2.split("=")[1]; // 1
            outPlayerService.퇴출등록(Integer.valueOf(exitregi5),exitregi4);


//            System.out.println("exitregi : "+ exitregi);
//            System.out.println("exitregi2 : "+ exitregi2);
//            System.out.println("exitregi3 : "+ exitregi3);
//            System.out.println("exitregi4 : "+ exitregi4);
//            System.out.println("exitregi5 : "+ exitregi5);



        }







        // 3.8 퇴출목록

    }

}

