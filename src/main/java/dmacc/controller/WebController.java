
/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 30, 2023
 */
package dmacc.controller;

import dmacc.model.PasswordEntry;
import dmacc.model.PasswordEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    PasswordEntryRepository repo;

    @GetMapping("/")
    public String viewAllPasswords(Model model) {
        model.addAttribute("passwordList", repo.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addNewPassword(Model model) {
        PasswordEntry passwordEntry = new PasswordEntry();
        model.addAttribute("passwordEntry", passwordEntry);
        return "input";
    }
    
    @GetMapping("/results")
    public String viewAll(Model model) {
        model.addAttribute("passwordList", repo.findAll());
        return "results";
    }

    @PostMapping("/add")
    public String addNewPassword(@ModelAttribute PasswordEntry passwordEntry, Model model) {
        repo.save(passwordEntry);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        PasswordEntry passwordEntry = new PasswordEntry();
        model.addAttribute("passwordEntry", passwordEntry);
        return "update-password";
    }

    @PostMapping("/update")
    public String updatePassword(@ModelAttribute PasswordEntry passwordEntry, Model model) {
        repo.save(passwordEntry);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        PasswordEntry passwordEntry = new PasswordEntry();
        model.addAttribute("passwordEntry", passwordEntry);
        return "delete";
    }

    @PostMapping("/delete")
    public String deletePassword(@RequestParam long id) {
        repo.deleteById(id);
        return "redirect:/";
    }

}

