package com.Sydorenko.controller;

import com.Sydorenko.model.Role;
import com.Sydorenko.model.User;
import com.Sydorenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**Создаем контроллер для добавления Пользователей,пользователь по умолчанию присваивается роль USER
 *
 */

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String userList( Model model){
        model.addAttribute("users",userService.getList());
        return "userlist";
    }
    @GetMapping("{user}")
    public String userEditForm( @PathVariable User user, Model model ){
        model.addAttribute("user",user);
        model.addAttribute("roles",Role.values());

        return "useredit";
    }
    @PostMapping
    public String userUpdate(@RequestParam("id") User user,@RequestParam String name,@RequestParam Map<String,String> form){
    user.setName(name);         //устанавливаем пользователю имя которое пришло с формы

    //берем все существующие в приложении роли, преобразуем массив этих ролей в стрим (java stream api), где получаем имена ролей и полученый список имён складываем в set
        Set<String> roles=Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
     //очищаем персистентную коллекцию от установленых ролей
    user.getRoles().clear();
    //если имя какого-то поля является именем роли, то ищем такую роль в enum Role и устанавливаем эти роли пользователю.
    for (String key:form.keySet()){
        if (roles.contains(key)){
            user.getRoles().add(Role.valueOf(key));
        }
    }

    userService.save(user);//сохраняем

        return "redirect:/user";
}
@GetMapping("/delete/{id}") //удаляем пользователя
    public String deleteUser(@PathVariable int id){
        userService.delete(userService.findById(id));
        return "redirect:/user";
}

}
