package by.htp.ll.dao;

import by.htp.ll.bean.User;

public interface UserDAO {
    User authorization (String login, String password);

    void createUser(User userInfo);

}
