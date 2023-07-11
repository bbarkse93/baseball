import service.StadiumService;
import service.TeamService;


import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        //      System.out.println("어떤 기능을 요청하시겠습니까?");
        //    String str = scanner.next();

//        if (str.equals("선수등록")){
        //      StadiumService stadiumDto = new StadiumService();
        //    stadiumDto.createStadium("서울");}

        //  else if (str.equals("야구장목록")){
        //    StadiumService stadiumDto = new StadiumService();
        //  stadiumDto.getAllStadiums();
        //}

        TeamService ts = new TeamService();
        ts.createTeam(4,"두산");

    }
}

