package pl.coderslab.medbaseproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.medbaseproject.entity.Role;
import pl.coderslab.medbaseproject.entity.User;
import pl.coderslab.medbaseproject.model.CurrentUser;
import pl.coderslab.medbaseproject.service.implementation.RoleServiceImpl;
import pl.coderslab.medbaseproject.service.implementation.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegistrationController {
    private UserServiceImpl userService;
    private RoleServiceImpl roleService;

    public RegistrationController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/registerNewPatient")
    public String formPatient(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        model.addAttribute("user", new User());
        return "registration/patientRegisterForm";
    }


    @PostMapping("/registerNewPatient")
    public String registerPatient(@ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration/patientRegisterForm";
        }
        this.userService.savePatient(user);
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findOneByName("ROLE_PATIENT"));
        return "redirect:/login";
    }

    @GetMapping("/registerNewDoctor")
    public String formDoctor(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        model.addAttribute("user", new User());
        return "registration/doctorRegisterForm";
    }

    @PostMapping("/registerNewDoctor")
    public String registerDoctor(@ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration/doctorRegisterForm";
        }
        this.userService.saveDoctor(user);
        Set<Role> doctorRoles = new HashSet<>();
        doctorRoles.add(roleService.findOneByName("ROLE DOCTOR"));
        return "redirect:/login";
    }
}
