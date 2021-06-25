package by.htp.main.controller;

import by.htp.main.entity.Customer;
import by.htp.main.entity.Question;
import by.htp.main.service.CustomerService;
import by.htp.main.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CustomerService customerService;


}
