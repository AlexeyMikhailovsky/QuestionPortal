package by.htp.main.QuestionPortal.service.validation;

import by.htp.main.QuestionPortal.entity.Question;

public class ValidationQuestion {

    public static boolean validateQuestion(Question question) {
        boolean result = true;

        if (question.getQuestion()==null || "".equals(question.getQuestion())) {
            result = false;
        }
        if (question.getQuestion().trim().isEmpty()) {
            result = false;
        }

        if (question.getToCustomerEmail()==null || "".equals(question.getToCustomerEmail())) {
            result = false;
        }
        if (question.getToCustomerEmail().trim().isEmpty()) {
            result = false;
        }

        if (question.getAnswerType()==null || "".equals(question.getAnswerType())) {
            result = false;
        }
        if (question.getAnswerType().trim().isEmpty()) {
            result = false;
        }


        return result;
    }
}
