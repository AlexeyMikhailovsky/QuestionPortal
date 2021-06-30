package by.htp.main.QuestionPortal.service.validation;

import by.htp.main.QuestionPortal.entity.Customer;

public class ValidationLogin {

    public static boolean validateAuthorisation(String email, String password) {

        boolean result = true;

        if (email==null || "".equals(email)) {
            result = false;
        }
        if (email.trim().isEmpty()) {
            result = false;
        }

        if (password==null || "".equals(password)) {
            result = false;
        }
        if (password.trim().isEmpty() || "".equals(password)) {
            result = false;
        }

        return result;
    }

    public static boolean validateAuthorisation(String email) {
        boolean result = true;

        if (email==null || "".equals(email)) {
            result = false;
        }
        if (email.trim().isEmpty()) {
            result = false;
        }
        return result;
    }
}
