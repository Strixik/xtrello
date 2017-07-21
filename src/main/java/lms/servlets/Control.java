package lms.servlets;

/**
 * Created by Надя on 18.07.2017.
 */
public class Control {
    public static String Check(String a, String b){
        String s = "  <a href=\"http://localhost:8080/\">"+ "Повернутись" + "</a>";
        if ((a == null)&&(b == null))return newUser();
        else if (a.equals("Strix")&& b.equals("4359848791")|| a.equals("Taras")&& b.equals("2259"))
            return "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>xTrello</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"../css/main1.css\" type=\"text/css\">\n" +
                    "    <meta name=\"description\"content=\"    \" >\n" +
                    "    <meta name=\"keywords\" content=\"     \">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "    <link href=\"../img/1494542760_Tiger.ico\" rel=\"shortcut icon\" type=\"image/x-icon\">\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <header>\n" +
                    "  <img class=\"img1\" src=\"../img/boardS.jpg\" alt=\"\">\n" +
                    "  <img class=\"img\" src=\"../img/Xtrello.jpg\" alt=\"\">\n" +
                    "  </header>\n" +
                    "  <div class=\"telo\">\n" +
                    "  <h3>"+a+" Project</h3>\n" +
                    "  <div class=\"info\"><h2>info</h2><textarea></textarea></div>\n" +
                    "  <div class=\"info\"><h2>TODO</h2><textarea></textarea></div>\n" +
                    "  <div class=\"info\"><h2>do</h2><textarea></textarea></div>\n" +
                    "  <div class=\"info\"><h2>done</h2><textarea></textarea></div>\n" +
                    "  </div>\n" +
                    "  <footer>\n" +
                    "  </footer>\n" +
                    "</body>\n" +
                    "</html>";
        else  return "<html lang=\"en\">\n" +
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
                "  <div>\n" +
                "  <form action =\"/\" method=\"post\">\n" +
                "  <h4>Login or Password faild</h4>\n" +
                s +
                "  </form>\n" +
                "  </div>\n" +
                "  <footer>\n" +
                "  </footer>\n" +
                "</body>\n" +
                "</html>";
    }
    public static String newUser(){
        return "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>xTrello</title>\n" +
                "    <link rel=\"stylesheet\" href=\"../css/main2.css\" type=\"text/css\">\n" +
                "    <meta name=\"description\" content=\"    \" >\n" +
                "    <meta name=\"keywords\" content=\"     \">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <link href=\"../img/1494542760_Tiger.ico\" rel=\"shortcut icon\" type=\"image/x-icon\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<header>\n" +
                "    <img class=\"img\" src=\"../img/Xtrello.jpg\" alt=\"\">\n" +
                "</header>\n" +
                "<div>\n" +
                "    <form action =\"/registration\" method=\"post\">\n" +
                "        <h3>Registration</h3>\n" +
                "        <input type=\"text\" alt=\"Login\" title=\"Login\" name =\"newLogin\" placeholder=\"Login\" >\n" +
                "        <input type=\"Password\" alt=\"Password\" title=\"Password\" name=\"newPassword\" placeholder=\"Password\" >\n" +
                "        <button class=\"sss\"  type=\"submit\" value=\"Registration\">Registration</button>\n" +
                "    </form>\n" +
                "</div>\n" +
                "<footer>\n" +
                "</footer>\n" +
                "</body>\n" +
                "</html>";
    }
}
