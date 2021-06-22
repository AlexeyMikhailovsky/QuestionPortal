package by.htp.ll.dao;

import by.htp.ll.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional()
public class SQLUserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User authorization(String login, String password) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("from User where login = " + login , User.class);
        System.out.println("kon");
        User user = new User();
        user =(User) theQuery.getSingleResult();
        return user;
    }

    @Override
    public void createUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        String password = user.getPassword();
        user.setPassword(password);
        user.setDate(java.time.LocalDateTime.now());
        currentSession.saveOrUpdate(user);
    }
}