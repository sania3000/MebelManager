package com.Sydorenko.controller;

import com.Sydorenko.service.CategoryService;
import com.Sydorenko.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** The controller class for handling general HTTP requests
 * @author Oleksandr Sydorenko
 */
@Controller
public class MainController {


    @Value("${welcome.message}")
    private String message;
    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index ( Model model ) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = "/403")
    public String Error403 () {
        return "403";
    }
}