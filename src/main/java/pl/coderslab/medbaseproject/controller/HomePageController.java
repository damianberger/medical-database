package pl.coderslab.medbaseproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medbaseproject.model.CurrentUser;

@Controller
public class HomePageController {

    @RequestMapping("/")
    public String homePage(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        return "index";
    }

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        return "login";
    }

}
