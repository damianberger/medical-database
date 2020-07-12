package pl.coderslab.medbaseproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medbaseproject.entity.Disease;
import pl.coderslab.medbaseproject.model.CurrentUser;
import pl.coderslab.medbaseproject.repository.DiseaseRepository;



@Controller
@RequestMapping("/disease")
public class DiseaseController {
    private DiseaseRepository diseaseRepository;

    public DiseaseController(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @GetMapping("/add")
    public String formDisease(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        model.addAttribute("disease", new Disease());
        return "disease/diseaseForm";
    }

    @PostMapping("/add")
    public String createDisease(@ModelAttribute Disease disease, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "disease/diseaseForm";
        }
        diseaseRepository.save(disease);
        return "redirect:/disease/list";
    }

    @GetMapping("/list")
    public String getList(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        model.addAttribute("diseases", diseaseRepository.findAll());
        return "disease/diseaseList";
    }

    @GetMapping("edit/{id}")
    public String editDiseaseForm(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable Long id) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        Disease disease = diseaseRepository.findById(id)
                .orElse(new Disease());
        model.addAttribute("disease", disease);
        return "disease/diseaseEdit";
    }

    @PostMapping("/edit/{id}")
    public String editDisease(@ModelAttribute Disease disease, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "disease/diseaseEdit";
        }
        diseaseRepository.save(disease);
        return "redirect:/disease/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable Long id) {
        if(currentUser != null) {
            model.addAttribute("principal", currentUser.getUser());
        }
        diseaseRepository.deleteById(id);
        return "redirect:/disease/list";
    }


}
