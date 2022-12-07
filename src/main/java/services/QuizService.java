package services;

import dao.QuizDao;
import model.Quiz;

import java.util.List;

public class QuizService {
    QuizDao quizDao = new QuizDao();

    public List<Quiz> getAll(){
        return quizDao.getAll();
    }
}
