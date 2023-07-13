package test;

import org.json.simple.JSONObject;
import service.StadiumService;

import java.lang.reflect.Parameter;

public class Player {
    public static void main(String[] args) {
        String[] params;
        String paramString;
        String[] values;
        String str = "선수등록?id=1&name=이대호&position=1루수";

        JSONObject jsonObject = new JSONObject();
        int id = (int) jsonObject.get("id");
        String name = (String) jsonObject.get("name");
        String position = (String) jsonObject.get("position");

        System.out.println("id:" + id + "name:" + name + "position:" + position);



//        if (str.split("?").equals()) {
//            params = str.split("\\?");
//            paramString = params[1];
//            values = paramString.split("=");
//
//            // 3.1
//            if (params[0].equals("야구장등록")) {
//                StadiumService stadiumService = new StadiumService();
//                stadiumService.야구장등록(values[1]);
//            }
//
//            String str1 = "";
//            str1 = str.substring(0,str.indexOf("?"));
//            System.out.println(str1);
//
//            String[] strings = str.substring(str.indexOf("?")+1).split("&");
//
//            for (int i = 0; i <strings.length ; i++) {
//                System.out.println(strings[i]);
//
//                if (i >= 0 && i <= 2) {
//                    String[] keyValue = strings[i].split("=");
//                    String key = keyValue[0];
//                    String value = keyValue[1];
//                    System.out.println("Key: " + key + ", Value: " + value);
//                }
//            }
//
//        } else {
//            // 3.2
//            if (str.equals("야구장목록")) {
//                StadiumService stadiumService = new StadiumService();
//                stadiumService.야구장목록();
//            }
//        }
//
//        String str1 = "";
//        str1 = str.substring(0,str.indexOf("?"));
//        System.out.println(str1);
//
//        String[] strings = str.substring(str.indexOf("?")+1).split("&");
//
//        for (int i = 0; i <strings.length ; i++) {
//            System.out.println(strings[i]);
//
//            if (i >= 0 && i <= 2) {
//                String[] keyValue = strings[i].split("=");
//                String key = keyValue[0];
//                String value = keyValue[1];
//                System.out.println("Key: " + key + ", Value: " + value);
//            }
        }

    }

