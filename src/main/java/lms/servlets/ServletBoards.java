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

@WebServlet(name = "ServletBoards", urlPatterns = {"/ServletBoards"})
public class ServletBoards extends HttpServlet {
    Sticker sticker = new Sticker();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("id");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(PageParts.getPageIndexTop());
        out.write(PageParts.getBoards(session.getAttribute("login").toString()));
        String addStiker = new String(request.getParameter("Sticker").getBytes("iso-8859-1"), "UTF-8");

        sticker.setSticker_name(addStiker);
        sticker.insertStiker_name(Integer.parseInt(session.getAttribute("id").toString()), sticker.getSticker_name());

         for (String s: sticker.getStickername(Integer.parseInt(session.getAttribute("id").toString()))){
             out.write(" <div class=\"info\">\n" +
                     "          <h2>"+s+"</h2>\n" +
                     "          <form action = \"/ServletBoards\">\n" +
                     "          <p>and11111111re</p>\n" +
                     "          <p>and111111111re</p>\n" +
                     "          <p>andr1111111111111e</p>\n" +
                     "          <p>andre</p><textarea name=\"inputtext\"></textarea>\n" +
                     "          <input type=\"submit\" value=\"send\" />\n" +
                     "          </form>\n" +
                     "      </div>");
        }

        out.println(PageParts.getPageIndexBottom());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("id");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(PageParts.getPageIndexTop());
        out.write(PageParts.getBoards((String)session.getAttribute("login")));
        for (String s: sticker.getStickername(Integer.parseInt(session.getAttribute("id").toString()))){
            out.write(" <div class=\"info\">\n" +
                    "          <h2>"+s+"</h2>\n" +
                    "          <form action = \"/ServletBoards\">\n" +
                    "          <p>and11111111re</p>\n" +
                    "          <p>and111111111re</p>\n" +
                    "          <p>andr1111111111111e</p>\n" +
                    "          <p>andre</p><textarea name=\"inputtext\"></textarea>\n" +
                    "          <input type=\"submit\" value=\"send\" />\n" +
                    "          </form>\n" +
                    "      </div>");
        }
        String text = new String(request.getParameter("inputtext").getBytes("iso-8859-1"), "UTF-8");
        String[] textList = text.split("\\n");
        sticker.setNote(textList);
        sticker.insertNote(Integer.parseInt(session.getAttribute("id").toString()));

        out.println(PageParts.getPageIndexBottom());
    }

}
