package by.htp.ll.service;

import by.htp.ll.bean.User;
import by.htp.ll.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    public UserServiceImpl() {
    }


    @Override
    public User authorization(String login, String password) {
        System.out.println("authorization service");
        User user = null;
        try {
            user = userDAO.authorization(login, password);
        }catch (Exception e) {

        }
        return user;
    }

    @Override
    public void createUser(User user) {
        String name = user.getName();
        String surname = user.getSurname();
        String email = user.getEmail();
        String password = user.getPassword();
        String phonenumber = user.getPhonenumber();

        try {
            userDAO.createUser(user);
        }catch (Exception e) {

        }
    }
}
