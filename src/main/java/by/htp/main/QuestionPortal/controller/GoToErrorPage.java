package by.htp.main.QuestionPortal.controller;

import by.htp.main.QuestionPortal.service.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/customer")
public class GoToErrorPage {

    @RequestMapping("/error")
    public String execute() throws ServiceException, IOException {
        return "error_page";
    }
}
