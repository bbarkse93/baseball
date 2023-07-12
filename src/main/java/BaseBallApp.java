import model.stadium.StadiumDao;
import org.json.simple.JSONObject;
import service.PlayerService;
import service.StadiumService;
import service.TeamService;


import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {
        String[] params;
        String paramString;
        String[] values;

        Scanner scanner = new Scanner(System.in);
        System.out.println("어떤 기능을 요청하시겠습니까?");
        String str = scanner.next();
//        String str = "야구장등록?name=잠실야구장";

        if (str.contains("?")) {
            params = str.split("\\?");
            paramString = params[1];
            values = paramString.split("=");

            // 3.1
            if (params[0].equals("야구장등록")) {
                StadiumService stadiumService = new StadiumService();
                stadiumService.야구장등록(values[1]);
            }

        } else {
            // 3.2
            if (str.equals("야구장목록")) {
                StadiumService stadiumService = new StadiumService();
                stadiumService.야구장목록();
            }
        }


//        paramString = params[1];
//        values = paramString.split("=");
//
//        if (params.length > 2) {
//            paramString = params[1];
//            values = paramString.split("&");
//
//        }


//
        // 3.3
//        if (params[0].equals("팀등록")){
//            if (params.length > 1) {
//                paramString = params[1];
//                values = paramString.split("&");
//                String path = values[0];
//                String path1 = values[1];
//                String[] division = path.split("=");
//                String stadiumId = division[0];


//            TeamService teamService = new TeamService();
//            teamService.팀등록();
    }
}
//
//        // 3.4
//        if (str.equals("팀목록")){
//
//        }
//
//        // 3.5
//        if (params[0].equals("선수등록"){
//
//        }
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
//        // 3.8
//        if (str.equals("퇴출목록")){
//
//        }


//    }
//}

