/*
package lms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;

*/
/**
 * Start servlet
 *//*

@WebServlet(name = "Start", urlPatterns = {"/"})
public class Start extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        out.println(PageParts.getPageTop());
        out.println(PageParts.postPage(user,password));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println(PageParts.getPageTop());
            out.write("<H1>Hello Servlet World!</H1>");
            out.println(PageParts.getBody());
            out.println(PageParts.getPageBottom());
        } finally {
            out.close();
        }
    }
}
*/
