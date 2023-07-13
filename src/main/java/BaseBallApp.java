import model.stadium.StadiumDao;
import org.json.simple.JSONObject;
import service.OutPlayerService;
import service.PlayerService;
import service.StadiumService;
import service.TeamService;


import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 기능을 요청하시겠습니까?");
        String str = sc.next();
//        String str = 팀목록?

        String[] params = str.split("\\?");
        String action = params[0];

        System.out.println("str : "+str);
        System.out.println("action : "+action);
//

        // 3.1
        if (action.equals("야구장등록")) {
            String paramString = params[1];
            String[] val1 = paramString.split("\\=");

            StadiumService stadiumService = new StadiumService();
            stadiumService.야구장등록(val1[1]);
        }

        if (action.equals("야구장목록")) {
            StadiumService stadiumService = new StadiumService();
            stadiumService.야구장목록();
        }

        // 3.3
        if (action.equals("팀등록")) {
            String paramString = params[1];
            String[] title = paramString.split("\\&");
            String teamId = title[0];

            String[] val1 = teamId.split("\\=");
            Integer.parseInt(val1[1]);
            String name = title[1];

            String[] val2 = name.split("\\=");

            TeamService teamService = new TeamService();
            teamService.팀등록(Integer.valueOf(val1[1]), val2[1]);


        }
//
        //3.4
        if (action.equals("팀목록")){
            TeamService teamService = new TeamService();
            teamService.팀목록();

        }
//
        // 3.5
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

            PlayerService playerService = new PlayerService();
            playerService.선수등록(Integer.valueOf(val1[1]), val2[1], val3[1]);
        }
//
//        // 3.6
//        if (params[0].equals("선수목록")){
//
//        }
//
//        //3.7
//        if (params[0].equals("퇴출등록")){
//
//        }
//
        // 3.8 퇴출목록
        if (action.equals("퇴출목록")){
            OutPlayerService outPlayerService = new OutPlayerService();
            outPlayerService.퇴출목록();

        }

    }
}


