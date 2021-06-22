package by.htp.ll.service;

import by.htp.ll.bean.User;

public interface UserService {

    User authorization (String login, String password);

    void createUser(User userInfo);

}
