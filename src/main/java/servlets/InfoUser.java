package servlets;

import dao.UserDao;
import model.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/info")
public class InfoUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        PrintWriter out = resp.getWriter();


        String login = (String) req.getSession().getAttribute("login");
        long idUser = (Long) req.getSession().getAttribute("id_user");
       User user = userService.getUser(idUser);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/view/info_user.jsp").forward(req,resp);

//        System.out.println("login    "+login);
//        System.out.println("id  " + idUser);


    }
}
