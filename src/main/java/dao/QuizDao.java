package dao;

import model.Quiz;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizDao implements Dao<Quiz> {


    @Override
    public List<Quiz> getAll() {
        String sql = "select * from quiz";
        List<Quiz> tests;
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            tests = new ArrayList<>();
            Quiz quiz;
            while (resultSet.next()) {
                quiz = new Quiz();
                quiz.setId(resultSet.getLong("id_quiz"));
                quiz.setName(resultSet.getString("name_quiz"));
                quiz.setTopic(resultSet.getString("topic_quiz"));
                quiz.setTime(resultSet.getInt("time_quiz"));
                quiz.setQuestion(resultSet.getInt("question_quiz"));
                quiz.setDifficult(resultSet.getInt("difficult_quiz"));
                tests.add(quiz);
            }
            return tests;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Quiz get(long id) {
        return null;
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(String login) {

    }
}
