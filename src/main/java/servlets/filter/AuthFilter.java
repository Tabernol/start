package servlets.filter;

import dao.DataSource;
import dao.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

//@WebServlet("/")
public class AuthFilter implements Filter {
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

        UserDao userDao = new UserDao();
        String role = "unknown";
        if (userDao.isUserExist(login) && userDao.isCorrectPassword(login, password)) {
            role = userDao.getRoleByLogin(login);
        }
        moveToMenu(req, res, role);

//        @SuppressWarnings("unchecked")
//        final AtomicReference<UserDao> dao = (AtomicReference<UserDao>) req.getServletContext().getAttribute("dao");
//
//        final HttpSession session = req.getSession();
//
//        //Logged user.
//        if (nonNull(session) &&
//                nonNull(session.getAttribute("login")) &&
//                nonNull(session.getAttribute("password"))) {
//
//            final String role = (String) session.getAttribute("role");
//
//            moveToMenu(req, res, role);
//
//
//        } else if (dao.get().userIsExist(login, password)) {
//
//            final String role = dao.get().getRoleByLoginPassword(login, password);
//
//            req.getSession().setAttribute("password", password);
//            req.getSession().setAttribute("login", login);
//            req.getSession().setAttribute("role", role);
//
//            moveToMenu(req, res, role);
//
//        } else {
//            moveToMenu(req, res, "unknown");
//        }
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
