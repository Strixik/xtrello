package lms.servlets;

import lms.models.Sticker;
import lms.view.PageParts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


import static lms.servlets.StickersServlet.sticker;

@WebServlet(name = "Servlet3", urlPatterns = {"/note"})
        public class NotesServlet extends HttpServlet {
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                PrintWriter out = response.getWriter();
                HttpSession session = request.getSession();
                session.getAttribute("login");
                session.getAttribute("id");
                String text = new String(request.getParameter("inputtext").getBytes("iso-8859-1"), "UTF-8");
                String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "UTF-8");
                if (text != null || text.equals("")){
                    sticker.setNote(text);
                    sticker.insertNote(Integer.parseInt(session.getAttribute("id").toString()),name,sticker.getNote());
                    response.sendRedirect("/");
                }
                else {
                    response.sendRedirect("/");
                }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.getAttribute("login");
        session.getAttribute("id");
        System.out.println("servlet 3");
      }
}
