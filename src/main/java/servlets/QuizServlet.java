package servlets;

import model.Quiz;
import services.QuizService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuizService quizService = new QuizService();
//        List<Quiz> all = quizService.getAll();
//        req.setAttribute("quizs", all);

//        Quiz q = new Quiz();
//        q.setName("Math3");
//        req.setAttribute("quiz", q);
       // System.out.println(all);
        String[] users = new String[]{"Tom", "Bob", "Sam"};
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/view/quiz.jsp").forward(req, resp);
    }
}
