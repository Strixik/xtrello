
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


@WebServlet(name = "Second", urlPatterns = {"/registration"})
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(PageParts.getPageTop());
        String ulogin = new String(request.getParameter("newLogin").getBytes("iso-8859-1"), "UTF-8");
        String upassword = new String(request.getParameter("newPassword").getBytes("iso-8859-1"), "UTF-8");
        User user = new User();
        user.setLogin(ulogin);
        user.setPassword(upassword);
        if (user.findByLogin(ulogin)){
            out.println(PageParts.getBusy());
        }else {
            user.insert(user.getLogin(),user.getPassword());
            out.println(PageParts.getGood());
            HttpSession session = request.getSession();
        }
        out.println(PageParts.getPageBottom());


    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println(PageParts.getPageTop());
            out.println(PageParts.getReg());
            out.println(PageParts.getPageBottom());

        } finally {
            out.close();
        }
    }
}
