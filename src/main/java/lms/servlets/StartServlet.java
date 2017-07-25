
package lms.servlets;
import lms.models.Sticker;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


@WebServlet(name = "First", urlPatterns = {"/*"})

public class StartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws
            ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userlogin = new String(request.getParameter("Login").getBytes("iso-8859-1"), "UTF-8");
        String userpassword = new String(request.getParameter("Password").getBytes("iso-8859-1"), "UTF-8");
        User user = new User();
        user.setLoginUsername(userlogin);
        user.setLoginPassword(userpassword);
        if(user.checkLogin()) {
            HttpSession session = request.getSession();
            session.setAttribute("login", user.getLogin());
            session.setAttribute("id", user.getId());
            System.out.println("Все добре ви зайшли" + session.getAttribute("login"));
            doGet(request, response);
            } else {
            out.write(PageParts.getTag("h3","Login    or    Password wrong!",""));
            out.write(PageParts.getTag("a","Back","href=\"/\""));
        }

        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.getAttribute("login");
        session.getAttribute("id");

        switch (request.getPathInfo()) {
            case "/":
                if (session.getAttribute("id") != null) {
                    //out.print(session.getAttribute("login"));
                    response.sendRedirect("/Board");

                } else {
                    out.println(PageParts.getPartialHtml(getServletContext().getRealPath("/WEB-INF/html/formlogin.html")));
                }
                break;
            case "/registration":
                out.println(PageParts.getPartialHtml(getServletContext().getRealPath("/WEB-INF/html/formregistration.html")));
                break;
            case "/exit":
                session.removeAttribute("login");
                session.removeAttribute("id");
                response.sendRedirect("/");
                break;
            case "/Board":
                String blabla = PageParts.getPartialHtml(getServletContext().getRealPath("/WEB-INF/html/sticker.html"));
                Integer id = Integer.parseInt(session.getAttribute("id").toString());
                out.write(PageParts.OutPrint(id,blabla));
                break;
        }
    }

}
