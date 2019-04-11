package com.Sydorenko.controller;

import com.Sydorenko.controller.Form.UserForm;
import com.Sydorenko.controller.validator.UserValidator;
import com.Sydorenko.model.Role;
import com.Sydorenko.model.User;
import com.Sydorenko.service.UserService;
import com.Sydorenko.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
/** The controller class for handling HTTP requests related to user
 * registration, login and logout.
 * @author Oleksandr Sydorenko
 */
@Controller
public class AuthController {
    // Иньектируем сервис для работы с пользователями
    @Autowired
    private UserService userService;
    @Autowired

    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping({"/registration"})
    public String registration( Model model) {
        model.addAttribute("userForm", new UserForm());

        return "registration";
    }
    @PostMapping(value = "/registration")
    public String registration( @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User newUser = new User();
        newUser.setEmail(userForm.getEmail());
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(userForm.getPassword()));
        newUser.setName(userForm.getName());
        newUser.setAddress(userForm.getAddress());
        newUser.setRoles(Collections.singleton(Role.USER));
        userService.save(newUser);

        securityService.autoLogin(userForm.getEmail(), userForm.getPassword());
        return "redirect:/index";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
