package by.htp.main.controller;

import by.htp.main.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
}
