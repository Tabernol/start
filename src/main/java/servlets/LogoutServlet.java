package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        System.out.println(login);


        final HttpSession session = req.getSession();
        boolean b = session.getAttributeNames().hasMoreElements();
        System.out.println(b);


        session.removeAttribute("password");
        session.removeAttribute("login");//???
        session.removeAttribute("role");

        resp.sendRedirect(super.getServletContext().getContextPath());
    }
}
