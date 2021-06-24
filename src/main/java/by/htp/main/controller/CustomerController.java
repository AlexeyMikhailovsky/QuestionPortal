package by.htp.main.controller;

import java.util.List;

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

    @RequestMapping("/edit")
    public String editPage(@RequestParam("customerId") int theId,
                           Model theModel){
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
        System.out.println("data: " + customer.getEmail()
                + " " + customer.getPassword());
        Customer theCustomer = customerService.authorization(customer.getEmail(),customer.getPassword());
        theModel.addAttribute("customer", theCustomer);
        return "main";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {

        Customer theCustomer = customerService.getCustomer(theId);

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {

        customerService.deleteCustomer(theId);

        return "login";
    }


}











