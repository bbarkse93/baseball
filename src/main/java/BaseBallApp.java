import db.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("어떤 기능을 요청하시겠습니까?");
        String str = scanner.next();


    }
}
