package lms.view;

import lms.models.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**Creates static parts for HTML page
 */
public class PageParts {
static String faild = "<h4>Login or Password wrong!</h4>";
static String faildnewuser = "<h4>This login is busy!</h4>";
static String good = "<h4 class=\"good\">Created a new user!</h4>";
static String a = "<a href=\"/\" >Come back</a>";
static String n = "<a href=\"/registration\" >Come back</a>";


    public static String getPageTop() {
        return "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>xTrello</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/main2.css\" type=\"text/css\">\n" +
                "    <meta name=\"description\" content=\"    \" >\n" +
                "    <meta name=\"keywords\" content=\"     \">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <link href=\"img/1494542760_Tiger.ico\" rel=\"shortcut icon\" type=\"image/x-icon\">\n" +
                "</head>\n" +
                "<body>\n" +
                "  <header>\n" +
                "  <img class=\"img\" src=\"img/Xtrello.jpg\" alt=\"\">\n" +
                "  </header>\n" +
                "  <div>\n";
    }
    public static String getEnter(){
        return  "  <form action =\"/\" method=\"post\">\n" +
                "  <h3>Singl in</h3>\n" +
                "  <input type=\"text\" alt=\"Login\" title=\"Login\" name =\"Login\" placeholder=\"Login\" >\n" +
                "  <input type=\"Password\" alt=\"Password\" title=\"Password\" name=\"Password\" placeholder=\"Password\" >\n" +
                "  <button class=\"sss\"  type=\"submit\" value=\"Enter\">Enter</button>\n" +
                "  <a href=\"/registration \">Registration</a>\n" +
                "  </form>\n";

    }
    public static ArrayList<String> list = new ArrayList<>();
    public static ArrayList<String> addStiker(String s){
        list.add(s);
        return list;
    }
    public static String postEnterFaild(){
        return  faild + a;
    }
    public static String getReg(){
        return  "    <form action =\"/registration\" method=\"post\">\n" +
                "        <h3>Registration</h3>\n" +
                "        <input type=\"text\" alt=\"Login\" title=\"Login\" name =\"newLogin\" placeholder=\"Login\" >\n" +
                "        <input type=\"Password\" alt=\"Password\" title=\"Password\" name=\"newPassword\" placeholder=\"Password\" >\n" +
                "        <button class=\"sss\"  type=\"submit\" value=\"Registration\">Registration</button>\n" +
                "    </form>\n";
    }
    public static String getBusy(){
        return faildnewuser + n;
    }
    public static String getBoards(String name){
        return  "      <h3>"+name+" Project</h3>\n" + "    <form action =\"/ServletBoards\" method=\"post\">\n" +
                "        <input type=\"text\" alt=\"Sticker\" title=\"Sticker\" name =\"Sticker\" placeholder=\"Name Sticker\" >\n" +
                "        <button class=\"sss\"  type=\"submit\" value=\"AddSticker\">AddSticker</button>\n" +
                "    </form>\n ";}
    public static String getGood(){
        return  good + a;
    }
    public static String getPageBottom() {
        return "  </div>\n" +
                "  <footer>\n" +
                "  </footer>\n" +
                "</body>\n" +
                "</html>";
    }
    public static String getPageIndexTop(){
    return " <!DOCTYPE html>\n" +
            "    <html lang=\"en\">\n" +
            "    <head>\n" +
            "        <meta charset=\"UTF-8\">\n" +
            "        <title>xTrello</title>\n" +
            "        <link rel=\"stylesheet\" href=\"../css/main1.css\" type=\"text/css\">\n" +
            "        <meta name=\"description\"content=\"    \" >\n" +
            "        <meta name=\"keywords\" content=\"     \">\n" +
            "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "        <link href=\"../img/1494542760_Tiger.ico\" rel=\"shortcut icon\" type=\"image/x-icon\">\n" +
            "    </head>\n" +
            "    <body>\n" +
            "      <header>\n" +
            "      <img class=\"img1\" src=\"../img/boardS.jpg\" alt=\"\">\n" +
            "      <img class=\"img\" src=\"../img/Xtrello.jpg\" alt=\"\">\n" +
            "      </header>\n" +
            "      <div class=\"telo\">";
    }
    public static String getPageIndexBottom(){
        return " </div>\n" +
                "      <footer>\n" +
                "      </footer>\n" +
                "    </body>\n" +
                "    </html>";
    }

}
