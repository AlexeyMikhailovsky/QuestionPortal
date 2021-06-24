package by.htp.main.dao;

import by.htp.main.entity.Question;

import java.util.List;

public interface QuestionDAO {

    public List<Question> getQuestions();

    public void saveQuestion(Question theQuestion);

    public Question getQuestion(int theId);

    public void deleteQuestion(int theId);

}
