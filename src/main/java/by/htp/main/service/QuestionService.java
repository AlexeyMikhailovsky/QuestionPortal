package by.htp.main.service;

import by.htp.main.entity.Question;

import java.util.List;

public interface QuestionService {

    public List<Question> getQuestions();

    public void saveQuestion(Question theQuestion);

    public Question getQuestion(int theId);

    public void deleteQuestions(int theId);

    public void deleteQuestion(int theId);

}
