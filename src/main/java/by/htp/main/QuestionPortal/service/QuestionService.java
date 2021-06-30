package by.htp.main.QuestionPortal.service;

import by.htp.main.QuestionPortal.entity.Question;
import by.htp.main.QuestionPortal.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.htp.main.QuestionPortal.service.validation.ValidationQuestion.validateQuestion;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Transactional
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Transactional
    public void saveQuestion(Question question) throws ServiceException{
        if(!validateQuestion(question)){
            throw new ServiceException("Some field are empty.");
        }
        questionRepository.save(question);
    }

    @Transactional
    public Question get(Long id) {
        return questionRepository.getById(id);
    }

    @Transactional
    public void deleteQuestions(Long id) {
        questionRepository.deleteQuestionsByCustomerId(id);
    }

    @Transactional
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Transactional
    public List<Question> getCustomerQuestions(Long id) {
        return questionRepository.getCustomerQuestions(id);
    }

    @Transactional
    public List<Question> getCustomerAnswers(String email){
        return questionRepository.getCustomerAnswers(email);
    }
}
