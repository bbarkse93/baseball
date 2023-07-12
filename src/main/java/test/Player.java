package test;

public class Player {
    public static void main(String[] args) {
        String aa = "선수등록?teamId=1&name=이대호&position=1루수";
        String str = aa.substring(0,aa.indexOf("?"));
        System.out.println(str);

        String[] strings = aa.substring(aa.indexOf("?")+1).split("&");

        for (int i = 0; i <strings.length ; i++) {
            System.out.println(strings[i]);
        }
    }
}
