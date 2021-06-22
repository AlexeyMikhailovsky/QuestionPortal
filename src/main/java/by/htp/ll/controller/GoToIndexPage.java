package by.htp.ll.controller;

import by.htp.ll.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage")
public class GoToIndexPage {

    @RequestMapping("/login")
    public String execute(Model theModel)  {

        User user = new User();

        theModel.addAttribute("user", user);

        return "login";
    }

}
