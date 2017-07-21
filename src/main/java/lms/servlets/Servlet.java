
package lms.servlets;
import lms.models.User;
import lms.view.PageParts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Start", urlPatterns = {"/"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(PageParts.getPageIndexTop());

        String userlogin = new String(request.getParameter("Login").getBytes("iso-8859-1"), "UTF-8");
        String userpassword = new String(request.getParameter("Password").getBytes("iso-8859-1"), "UTF-8");
        User user = new User();
        user.setLoginUsername(userlogin);
        user.setLoginPassword(userpassword);
        if(user.checkLogin()) {
            HttpSession session = request.getSession();
            session.setAttribute("login", user.getLogin());
            // save data in session
            session.setAttribute("id", user.getId());
            response.sendRedirect("/ServletBoards");
            } else {
           out.println(PageParts.postEnterFaild());
        }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println(PageParts.getPageTop());
            out.println(PageParts.getEnter());
            out.println(PageParts.getPageBottom());

        } finally {
            out.close();
        }
    }
}
