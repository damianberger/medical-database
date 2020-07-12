package pl.coderslab.medbaseproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medbaseproject.entity.Drug;
import pl.coderslab.medbaseproject.model.CurrentUser;
import pl.coderslab.medbaseproject.repository.DrugRepository;



@Controller
@RequestMapping("/drug")
public class DrugController {
    private DrugRepository drugRepository;

    public DrugController(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @GetMapping("/add")
    public String formDrug(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        model.addAttribute("drug", new Drug());
        return "drug/drugForm";
    }

    @PostMapping("/add")
    public String createDrug(@ModelAttribute Drug drug, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "drug/drugForm";
        }
        drugRepository.save(drug);
        return "redirect:/drug/list";
    }

    @GetMapping("/list")
    public String getList(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        model.addAttribute("drugs", drugRepository.findAll());
        return "drug/drugList";
    }

    @GetMapping("edit/{id}")
    public String editDrugForm(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable Long id) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        Drug drug = drugRepository.findById(id)
                .orElse(new Drug());
        model.addAttribute("drug", drug);
        return "drug/drugEdit";
    }

    @PostMapping("/edit/{id}")
    public String editDrug(@ModelAttribute Drug drug, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "drug/drugEdit";
        }
        drugRepository.save(drug);
        return "redirect:/drug/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable Long id) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        drugRepository.deleteById(id);
        return "redirect:/drug/list";
    }


}
