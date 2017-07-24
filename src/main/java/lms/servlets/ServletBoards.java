
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

@WebServlet(name = "Third", urlPatterns = {"/Boards"})
public class ServletBoards extends HttpServlet {
   static Sticker sticker = new Sticker();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("id");
        session.getAttribute("login");
        PrintWriter out = response.getWriter();
        String addStiker = new String(request.getParameter("stickerName").getBytes("iso-8859-1"), "UTF-8");

        if (addStiker == null || addStiker.equals("")){
           response.sendRedirect("/");
       }else {
           sticker.setSticker_name(addStiker);
           sticker.insertStiker_name(Integer.parseInt(session.getAttribute("id").toString()), sticker.getSticker_name());
           response.sendRedirect("/Boards");
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("id");
        session.getAttribute("login");
        PrintWriter out = response.getWriter();
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
            out.write(form1);
        }

     // out.write( session.getAttribute("id").toString() + session.getAttribute("login") + sticker.getSticker_name());
      /*  for (String x : Sticker.getStickername(Integer.parseInt(session.getAttribute("id").toString()))){
            out.println(PageParts.getPartialHtml(getServletContext().getRealPath("/WEB-INF/html/sticker.html")));
        }*/

    }

}



