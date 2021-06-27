package by.htp.main.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import by.htp.main.entity.Question;
import by.htp.main.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.main.entity.Customer;
import by.htp.main.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/mainpage")
    public String toMainPage(@RequestParam("customerId") int theId,
                             Model theModel){
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("questions", someQ(theCustomer.getId(), theCustomer.getEmail(), true));
        return "main";
    }

    @PostMapping("/main")
    public String mainPage(@ModelAttribute("customer") Customer theCustomer,
                           Model theModel){
        customerService.saveCustomer(theCustomer);
        theModel.addAttribute("questions", someQ(theCustomer.getId(), theCustomer.getEmail(), true));
        return "main";
    }


    @RequestMapping("/edit")
    public String editPage(@RequestParam("customerId") int theId,
                           Model theModel){
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "edit";
    }


    @RequestMapping("/login")
    public String logginPage(Model theModel){
        Customer customer = new Customer();
        theModel.addAttribute("customer", customer);
        return "login";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("customer") Customer customer, Model theModel) {
        Customer theCustomer = oneC(customer.getEmail());
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("questions", someQ(theCustomer.getId(), theCustomer.getEmail(), true));
        return "main";
    }

    private Customer oneC(String email){
        Customer theCustomer = new Customer();
        List<Customer> theCustomers = customerService.getCustomers();
        for (Customer c: theCustomers) {
            if (email.equals(c.getEmail())){
                theCustomer = c;
            }
        }
        return theCustomer;
    }

    private List<Question> someQ(int id, String email, boolean f){ //true - questions false- answer
        List<Question> questions = questionService.getQuestions();
        CopyOnWriteArrayList<Question> theQuestions = new CopyOnWriteArrayList<>();
        theQuestions.addAll(questions);

        if (f) {
            for (Question q: theQuestions) {
                if (q.getIdCustomer() != id ){
                    theQuestions.remove(q);
                }
            }
        }
        else  {
            for (Question q: theQuestions) {
                if ( !(email.equals(q.getToCustomerEmail())) ){
                    theQuestions.remove(q);
                }
            }
        }
        questions.clear();
        questions.addAll(theQuestions);
        return questions;
    }

    @GetMapping("/showQuestionForm")
    public String showQuestionForm(@RequestParam("customerId") int theId,
                                   Model theModel) {
        Question theQuestion = new Question();
        theModel.addAttribute("question", theQuestion);
        theModel.addAttribute("customer", customerService.getCustomer(theId));
        return "changeQuestion";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("question") Question theQuestion, Model theModel) {
        questionService.saveQuestion(theQuestion);
        Customer theCustomer = customerService.getCustomer(theQuestion.getIdCustomer());
        theModel.addAttribute("customer",theCustomer);
        theModel.addAttribute("questions", someQ(theCustomer.getId(), theCustomer.getEmail(), true));
        return "main";
    }

    @GetMapping("/showFormQuestionForUpdate")
    public String showFormQuestionForUpdate(@RequestParam("customerId") int theId, @RequestParam("questionId") int theIdQ,
                                    Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);
        Question theQuestion = questionService.getQuestion(theIdQ);
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("question", theQuestion);
        return "changeQuestion";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/questionDelete")
    public String deleteQuestion(@RequestParam("customerId") int theCustomerId, @RequestParam("questionId") int theQuestionId,
                                 Model theModel) {
        questionService.deleteQuestion(theQuestionId);
        Customer theCustomer = customerService.getCustomer(theCustomerId);
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("questions", someQ(theCustomer.getId(), theCustomer.getEmail(), true));
        return "main";
    }

    @PostMapping("/processDelete")
    public String deleteCustomer(@ModelAttribute("customer") Customer theCustomer) {
        questionService.deleteQuestions(theCustomer.getId());
        customerService.deleteCustomer(theCustomer.getId());
        return "redirect:/customer/login";
    }

    @GetMapping("/delete")
    public String deletePage(@RequestParam("customerId") int theId,
                             Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "delete";
    }

    @GetMapping("/answerpage")
    public String answerPage(@RequestParam("customerId") int theId,
                             Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("questions", someQ(theId, theCustomer.getEmail(), false));//change to
        return "answer";
    }

    @GetMapping("/toanswer")
    public String toAnswer(@RequestParam("questionIdQ") int theIdQ, @RequestParam("customerId") int theId,
                             Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("question", questionService.getQuestion(theIdQ));//change to
        return "answerpage";
    }

    @PostMapping("/saveAnswer")
    public String saveAnswer(@ModelAttribute("question") Question theQuestion, Model theModel) {
        questionService.saveQuestion(theQuestion);
        Customer theCustomer = oneC(theQuestion.getToCustomerEmail());
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("questions", someQ(theCustomer.getId(), theCustomer.getEmail(), false));
        return "answer";
    }
}











