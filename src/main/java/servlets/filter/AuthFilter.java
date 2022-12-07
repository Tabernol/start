package servlets.filter;

import dao.DataSource;
import model.Quiz;
import services.QuizService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/")
public class AuthFilter implements Filter {
    private UserService userService = new UserService();
    private QuizService quizService = new QuizService();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        DataSource.init();
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        System.out.println(login);

        final HttpSession session = req.getSession();


        String role = "unknown";
        long id = userService.getId(login);
        if (id > 0 && userService.isCorrectPassword(id, password)) {
            role = userService.getRoleById(id);
            req.getSession().setAttribute("id_user", id);// get id
        }
        moveToMenu(req, res, role);
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final String role)
            throws ServletException, IOException {


        if (role.equals("admin")) {
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);
        } else if (role.equals("user")) {
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }


    @Override
    public void destroy() {
    }

}
