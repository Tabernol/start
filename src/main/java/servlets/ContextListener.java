//package servlets;
//
//import dao.DataSource;
//import dao.UserDao;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import java.util.concurrent.atomic.AtomicReference;
//
//public class ContextListener implements ServletContextListener {
//    private AtomicReference<UserDao> dao;
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//
//        dao = new AtomicReference<>(new UserDao());
//
//        final ServletContext servletContext =
//                servletContextEvent.getServletContext();
//
//        servletContext.setAttribute("dao", dao);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        dao = null;
//    }
//
//}
