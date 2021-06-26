package by.htp.main.dao;

import by.htp.main.entity.Customer;
import by.htp.main.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Question> getQuestions() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Question> theQuery =
                currentSession.createQuery("from Question order by toCustomerEmail",
                        Question.class);
        List<Question> questions = theQuery.getResultList();
        return questions;
    }

    @Override
    public void saveQuestion(Question theQuestion) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theQuestion);
    }

    @Override
    public Question getQuestion(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Question theQuestion = currentSession.get(Question.class, theId);
        return theQuestion;

    }

    @Override
    public void deleteQuestions(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery =
                currentSession.createQuery("delete from Question where idCustomer=:questionId");
        theQuery.setParameter("questionId", theId);
        theQuery.executeUpdate();
    }

    @Override
    public void deleteQuestion(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery =
                currentSession.createQuery("delete from Question where idQ=:questionId");
        theQuery.setParameter("questionId", theId);

        theQuery.executeUpdate();
    }
}
