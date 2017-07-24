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

import static lms.servlets.ServletBoards.sticker;

@WebServlet(name = "Servlet3", urlPatterns = {"/note"})
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.getAttribute("login");
        session.getAttribute("id");
        String text = new String(request.getParameter("inputtext").getBytes("iso-8859-1"), "UTF-8");
        String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "UTF-8");
        sticker.setNote(text);
        sticker.insertNote(Integer.parseInt(session.getAttribute("id").toString()),name,sticker.getNote());
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.getAttribute("login");
        session.getAttribute("id");

        for (String x : PageParts.DelDubl(Sticker.getStickername(Integer.parseInt(session.getAttribute("id").toString())))){
            String form1 = PageParts.getPartialHtml(getServletContext().getRealPath("/WEB-INF/html/sticker.html"));
            form1 = form1.replace("<!-- servletInsert05 -->",x);
            form1 = form1.replace("<!-- servletInsert06 -->",x);
            StringBuilder stringBuilder = new StringBuilder();
            for (String y : Sticker.getNote(Integer.parseInt(session.getAttribute("id").toString()),x)){
                if (y == null){
                    continue;
                } else stringBuilder.append(PageParts.getTag("p",y,""));
            }

            form1 = form1.replace("<!-- servletInsert07 -->",stringBuilder);
            System.out.println(stringBuilder);
            out.write(form1);
        }
    }
}
