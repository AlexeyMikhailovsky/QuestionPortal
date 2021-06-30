package by.htp.main.QuestionPortal.controller;

import by.htp.main.QuestionPortal.entity.Customer;
import by.htp.main.QuestionPortal.entity.Question;
import by.htp.main.QuestionPortal.mail.EmailCfg;
import by.htp.main.QuestionPortal.service.CustomerService;
import by.htp.main.QuestionPortal.service.QuestionService;
import by.htp.main.QuestionPortal.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private EmailCfg emailCfg;

    @Autowired
    CustomerService customerService;

    @Autowired
    QuestionService questionService;

    @RequestMapping("/login")
    public String loginPage(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "registration";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer, Model model) throws ServiceException{
        customerService.save(theCustomer);
        model.addAttribute("customer",theCustomer);

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.mailtrap.io");
        mailSender.setPort(2525);
        mailSender.setUsername("c9478c4120008c");
        mailSender.setPassword("3e0c3f55334fd5");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(theCustomer.getEmail());
        mailMessage.setTo("rc@feedback.com");
        mailMessage.setSubject("You have been registered by name: " + theCustomer.getEmail());
        mailMessage.setText("Congrats!!");

        mailSender.send(mailMessage);

        return "main";
    }

    @RequestMapping("/edit")
    public String editPage(@RequestParam("customerId") Long id,
                           Model model){

        Customer customer = customerService.getById(id);

        model.addAttribute("customer", customer);

        return "edit_profile";
    }

    @RequestMapping("/main")
    public String mainPage(@RequestParam("customerId") Long id,
                           Model model){

        Customer customer = customerService.getById(id);

        model.addAttribute("customer", customer);
        model.addAttribute("questions", questionService.getCustomerQuestions(id));
        return "main";
    }

    @RequestMapping("/logination")
    public String logination(@ModelAttribute("customer") Customer customer, Model model) throws ServiceException{
        Customer theCustomer = customerService.getCustomerByEmail(customer.getEmail());
        model.addAttribute("customer", theCustomer);
        model.addAttribute("questions", questionService.getCustomerQuestions(theCustomer.getId()));

        return "main";
    }

    @GetMapping("/delete")
    public String deletePage(@RequestParam("customerId") Long id,
                             Model theModel) {
        Customer customer = customerService.getById(id);
        theModel.addAttribute("customer", customer);
        return "delete";
    }

    @PostMapping("/processDelete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.mailtrap.io");
        mailSender.setPort(2525);
        mailSender.setUsername("c9478c4120008c");
        mailSender.setPassword("3e0c3f55334fd5");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(customer.getEmail());
        mailMessage.setTo("rc@feedback.com");
        mailMessage.setSubject("You have been registered by name: " + customer.getEmail());
        mailMessage.setText("Congrats!!");

        mailSender.send(mailMessage);

        questionService.deleteQuestions(customer.getId());
        customerService.deleteById(customer.getId());

        return "redirect:/customer/login";
    }

    @GetMapping("/addQuestion")
    public String addQuestion(@RequestParam("customerId") Long id,
                                   Model model) {
        Question theQuestion = new Question();
        model.addAttribute("thequestion", theQuestion);
        model.addAttribute("customer", customerService.getById(id));
        return "question";
    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("thequestion") Question theQuestion, Model model) throws ServiceException{
        questionService.saveQuestion(theQuestion);
        Customer theCustomer = customerService.getById(theQuestion.getIdCustomer());
        model.addAttribute("customer",theCustomer);
        model.addAttribute("questions", questionService.getCustomerQuestions(theCustomer.getId()));
        return "main";
    }

    @GetMapping("/questionDelete")
    public String deleteQuestion(@RequestParam("customerId") Long theCustomerId, @RequestParam("questionId") Long theQuestionId,
                                 Model theModel) {
        questionService.deleteById(theQuestionId);
        Customer theCustomer = customerService.getById(theCustomerId);
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("questions", questionService.getCustomerQuestions(theCustomer.getId()));
        return "main";
    }

    @GetMapping("/editquestion")
    public String editQuestion(@RequestParam("customerId") Long theId, @RequestParam("questionId") Long theIdQ,
                                            Model theModel) {

        Customer theCustomer = customerService.getById(theId);
        Question theQuestion = questionService.get(theIdQ);

        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("thequestion", theQuestion);

        return "question";
    }

    @GetMapping("/answerpage")
    public String answerPage(@RequestParam("customerId") Long theId,
                             Model theModel) {

        Customer theCustomer = customerService.getById(theId);

        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("questions", questionService.getCustomerAnswers(theCustomer.getEmail()));
        return "answer";
    }

    @GetMapping("/toanswer")
    public String toAnswer(@RequestParam("questionIdQ") Long theIdQ, @RequestParam("customerId") Long theId,
                           Model theModel) {

        Customer theCustomer = customerService.getById(theId);

        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("thequestion", questionService.get(theIdQ));
        return "answerpage";
    }

    @PostMapping("/saveAnswer")
    public String saveAnswer(@ModelAttribute("thequestion") Question theQuestion, Model theModel) throws ServiceException{
        questionService.saveQuestion(theQuestion);
        Customer customer = customerService.getCustomerByEmail(theQuestion.getToCustomerEmail());
        theModel.addAttribute("customer", customer);
        theModel.addAttribute("questions", questionService.getCustomerAnswers(customer.getEmail()));

        return "answer";
    }
}
