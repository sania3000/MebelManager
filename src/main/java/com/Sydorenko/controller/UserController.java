package com.Sydorenko.controller;

import com.Sydorenko.model.Role;
import com.Sydorenko.model.User;
import com.Sydorenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String userList( Model model){
        model.addAttribute("users",userService.getList());
        return "userlist";
    }
    @GetMapping("{id}")
    public String userEditForm( @PathVariable int id, Model model ){
        model.addAttribute("user",userService.findById(id));
        model.addAttribute("roles",Role.values());

        return "useredit";
    }
    @PostMapping
    public String userUpdate(@RequestParam int id,@ModelAttribute User user){
    User user1=userService.findById(id);
    user1.setName(user.getName());
    userService.save(user1);

        return "redirect:/user";
}
@GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.delete(userService.findById(id));
        return "redirect:/user";
}

}
