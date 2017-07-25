package lms.servlets;

import lms.models.Sticker;
import lms.view.PageParts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "PageFilterLogin", value = {"/*", "/reg", "/Boards"})
public class PageFilterLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpServletRequest request =(HttpServletRequest) req;
        HttpServletResponse response =(HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String top = PageParts.getPartialHtml(req.getServletContext().getRealPath("/WEB-INF/html/toplogin.html"));
        String button = PageParts.getPartialHtml(req.getServletContext().getRealPath("/WEB-INF/html/bottomindex.html"));
        if (session.getAttribute("id") == null){
        String css2 = "<link rel=\"stylesheet\" href=\"../css/main2.css\" type=\"text/css\">";
       top = top.replace(" <!-- servletInsert01 -->",css2);

        }

        if (session.getAttribute("id") != null){

            String css1 ="<link rel=\"stylesheet\" href=\"../css/main1.css\" type=\"text/css\">";
            String img = "<img class=\"img1\" src=\"../img/boardS.jpg\" alt=\"\">";
            String form = " <form action=\"/sticker\" method=\"post\">\n" +
                    "        <input type=\"submit\"  name =\"\" placeholder=\"\" value=\"Enter\" >\n" +
                    "        <input type=\"text\" alt=\"stickerName\" title=\"stickerName\" name =\"stickerName\" placeholder=\"Sticker name\" >\n" +
                    "    </form>";
            String div = "<div class=\"telo\">\n" +
                    "    <h3>" + session.getAttribute("login") + " Project</h3>\n";
            top =  top.replace(" <!-- servletInsert01 -->",css1);
            top =  top.replace(" <!-- servletInsert02 -->",img);
            top =  top.replace(" <!-- servletInsert03 -->",form);
            top =  top.replace(" <!-- servletInsert04 -->"," <a class=\"exit\" href=\"/exit\" >EXIT</a>");
            top =  top.replaceAll("<div>",div);
            top =  top.replaceAll("<div class=\"position\">","");

            }
        out.write(top);
        chain.doFilter(req,resp);
        out.write(button);

           // response.sendRedirect("/ServletBoards");
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
