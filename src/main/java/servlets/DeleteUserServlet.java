package servlets;

import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        userService.deleteUser(login);

    }
}
