package util;

/**
 * 储存所有常量
 */
public interface IConst {

    String IP_ADDRESS = "http://39.108.92.84/";
//    String IP_ADDRESS = "http://localhost:8080/";

    String IP_CONTEXT = IP_ADDRESS + "FavoriteTeacher/";

    //导师头像的访问地址
    String ICON_ADDRESS = IP_ADDRESS + "teacher/";

    //导师头像实际存放地址
    String ICON_PATH = "/usr/local/tomcat/webapps/ROOT/teacher/";

    int PAGE_INDEX_TEACHERS = 0;
    int PAGE_INDEX_Activity = 1;

    String SESSION_USER = "user";

}
