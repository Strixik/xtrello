
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
        HttpSession session = request.getSession();
        session.getAttribute("login");
        session.getAttribute("id");

        Sticker sticker = new Sticker();
        User user = new User();

        switch (request.getPathInfo()) {
            case "/": {
                String userlogin = new String(request.getParameter("Login").getBytes("iso-8859-1"), "UTF-8");
                String userpassword = new String(request.getParameter("Password").getBytes("iso-8859-1"), "UTF-8");

                user.setLoginUsername(userlogin);
                user.setLoginPassword(userpassword);

                if (user.checkLogin()) {
                    session.setAttribute("login", user.getLogin());
                    session.setAttribute("id", user.getId());
                    System.out.println("Все добре ви зайшли" + session.getAttribute("login"));
                    doGet(request, response);
                } else {
                    out.write(PageParts.getTag("h3", "Login    or    Password wrong!", ""));
                    out.write(PageParts.getTag("a", "Back", "href=\"/\""));
                }
            }
            break;

            case "/registration": {
                String ulogin = new String(request.getParameter("newLogin").getBytes("iso-8859-1"), "UTF-8");
                String upassword = new String(request.getParameter("newPassword").getBytes("iso-8859-1"), "UTF-8");
                String uemail = new String(request.getParameter("newEmail").getBytes("iso-8859-1"), "UTF-8");
                user.setLogin(ulogin);
                user.setPassword(upassword);
                user.setEmail(uemail);

                if (user.findByLogin(ulogin)) {

                    out.write(PageParts.getTag("h3", "This login is busy!", ""));
                    out.write(PageParts.getTag("a", "Back", "href=\"/registration\""));
                } else {
                    if (user.getLogin() == null || user.getLogin().equals("") || user.getPassword() == null || user.getPassword().equals("") || user.getEmail() == null || user.getEmail().equals("")) {
                        out.write(PageParts.getTag("h3", "Empty fields!", ""));
                        out.write(PageParts.getTag("a", "Back", "href=\"/registration\""));
                    } else {
                        user.insert(user.getLogin(), user.getPassword(), user.getEmail());
                        out.write(PageParts.getTag("h3", "Created a new user!", ""));
                        out.write(PageParts.getTag("a", "Back", "href=\"/\""));
                    }
                }
            }
            break;

            case "/sticker": {
                String addStiker = new String(request.getParameter("stickerName").getBytes("iso-8859-1"), "UTF-8");

                if (addStiker == null || addStiker.equals("")) {
                    response.sendRedirect("/");
                } else {

                    sticker.setSticker_name(addStiker);
                    sticker.insertStiker_name(Integer.parseInt(session.getAttribute("id").toString()), sticker.getSticker_name());
                    response.sendRedirect("/");
                }
            }
                break;
            case "/note": {
                String text = new String(request.getParameter("inputtext").getBytes("iso-8859-1"), "UTF-8");
                String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "UTF-8");
                if (text != null || text.equals("")) {
                    sticker.setNote(text);
                    sticker.insertNote(Integer.parseInt(session.getAttribute("id").toString()), name, sticker.getNote());
                    response.sendRedirect("/");
                } else {
                    response.sendRedirect("/");
                }
            }
            break;

        case "/del": {

            String name = new String(request.getParameter("s_name").getBytes("iso-8859-1"), "UTF-8");
                sticker.dellSticker(Integer.parseInt(session.getAttribute("id").toString()), name);
                response.sendRedirect("/");
            }

        break;
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
                    response.sendRedirect("/sticker");

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
            case "/sticker":
                String blabla = PageParts.getPartialHtml(getServletContext().getRealPath("/WEB-INF/html/sticker.html"));
                Integer id = Integer.parseInt(session.getAttribute("id").toString());
                out.write(PageParts.OutPrint(id,blabla));
                break;
        }
    }

}
