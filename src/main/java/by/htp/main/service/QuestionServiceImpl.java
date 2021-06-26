package by.htp.main.service;

import by.htp.main.dao.QuestionDAO;
import by.htp.main.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionDAO questionDAO;

    @Transactional
    public List<Question> getQuestions() {
        return questionDAO.getQuestions();
    }

   @Transactional
    public void saveQuestion(Question theQuestion) {
        questionDAO.saveQuestion(theQuestion);
    }

   @Transactional
    public Question getQuestion(int theId) {
        return questionDAO.getQuestion(theId);
    }

    @Transactional
    public void deleteQuestions(int theId) {
        questionDAO.deleteQuestions(theId);
    }

    @Transactional
    public void deleteQuestion(int theId) {
        questionDAO.deleteQuestion(theId);
    }
}
