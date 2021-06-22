package by.htp.ll.controller;

public class ControllerLevelConstant {

    //ATTRIBUTES
    String SINGLE_USER_ATTRIBUTE = "singleUser";
    String USER_ATTRIBUTE = "users";
    String MESSAGE = "message";
    String USER = "user";

    //PATHS
    String REDIRECT_AFTER_SAVING_NEW_USER = "/Controller/user";
    String REDIRECT_ON_ERROR_WHENSAVING_NEW_USER = "/AdminController/user/new";
    String REDIRECT_AFTER_SAVING_NEW_USER_TO_VIEW_PAGE = "/Controller/user/";
    String REDIRECT_TO_ERROR_PAGE = "/AnonymousController/error";

    String GO_TO_EDIT_PAGE = "edit";
    String GO_TO_ERROR_PAGE = "error_page";
    String GO_TO_VIEW_PAGE = "view";
    String GO_TO_LOGIN_PAGE = "login";
    String GO_TO_LIST_PAGE = "list";
    String GO_TO_NEW_PAGE = "new";
    String  REDIRECT_PREFIX = "redirect:";

}
