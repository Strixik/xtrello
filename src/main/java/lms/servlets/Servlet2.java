
package lms.servlets;
import lms.models.User;
import lms.view.PageParts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Second", urlPatterns = {"/reg"})
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws
            ServletException, IOException {
        PrintWriter out = response.getWriter();

        String ulogin = new String(request.getParameter("newLogin").getBytes("iso-8859-1"), "UTF-8");
        String upassword = new String(request.getParameter("newPassword").getBytes("iso-8859-1"), "UTF-8");
        String uemail = new String(request.getParameter("newEmail").getBytes("iso-8859-1"), "UTF-8");
        User user = new User();
        user.setLogin(ulogin);
        user.setPassword(upassword);
        user.setEmail(uemail);
        if (user.findByLogin(ulogin)){

            out.write(PageParts.getTag("h3","This login is busy!",""));
            out.write(PageParts.getTag("a","Back","href=\"/registration\""));
        }
        else {
            if (user.getLogin() == null || user.getLogin().equals("") || user.getPassword() == null || user.getPassword().equals("")|| user.getEmail() == null || user.getEmail().equals("")){
                out.write(PageParts.getTag("h3","Empty fields!",""));
                out.write(PageParts.getTag("a","Back","href=\"/registration\""));
            }
            else {
            user.insert(user.getLogin(),user.getPassword(), user.getEmail());
            out.write(PageParts.getTag("h3","Created a new user!",""));
            out.write(PageParts.getTag("a","Back","href=\"/\""));
            HttpSession session = request.getSession();}
        }


    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws
            ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {





        } finally {
            out.close();
        }
    }
}
