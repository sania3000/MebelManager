package com.Sydorenko.controller;

import com.Sydorenko.controller.Form.CategoryForm;
import com.Sydorenko.controller.Form.FurnitureForm;
import com.Sydorenko.model.Categories;
import com.Sydorenko.model.Furnitures;
import com.Sydorenko.service.CategoryService;
import com.Sydorenko.service.FurnitureService;
import com.Sydorenko.service.UserService;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Date;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    FurnitureService furnitureService;
    @Autowired
    CategoryService categoryService;

    @Value("${welcome.message}")
    private String message;
    @Value("${error.message}")
    private String errorMessage;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index ( Model model ) {
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(value = {"/listcategories"})
    public String categoryList ( Model model ) {
        model.addAttribute("categories", categoryService.getAll());
        CategoryForm categoryForm = new CategoryForm();
        model.addAttribute("categoryform", categoryForm);

        return "listcategories";
    }


    @PostMapping(value = {"addcategory"})
    public String saveCategory ( Model model, @ModelAttribute("categoryform") CategoryForm categoryForm ) {


        String category = categoryForm.getCategory();


        if (category != null && !category.isEmpty()) {
            Categories newcategory = new Categories();
            newcategory.setCategory(category);

            categoryService.save(newcategory);

            return "redirect:/listcategories";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "listcategories";

    }

    @GetMapping(value = {"delete/{id}"})
    public String deleteCategory ( @PathVariable(value = "id") int id ) {

        categoryService.remove(categoryService.findById(id));

        return "redirect:/listcategories";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String editCategory ( @PathVariable(value = "id") int id, Model model ) {

        model.addAttribute("categories", categoryService.findById(id));


        return "updatecategory";

    }

    @PostMapping(value = {"/updatecategory"})
    public String updateCategory ( @ModelAttribute Categories categories ) {

//        categoryService.update(categories.getCategory(),categories.getId());
        return "redirect:/listcategories";
    }


    @GetMapping(value = {"listfurniture/{id}"})
    public String furnitureList ( @PathVariable("id") int id, Model model ) {
        model.addAttribute("categories",categoryService.findById(id));
        model.addAttribute("furnitures", furnitureService.findByCategory(categoryService.findById(id)));
        FurnitureForm furnitureForm = new FurnitureForm();
        model.addAttribute("furnitureform", furnitureForm);

        return "listfurniture";
    }

    @PostMapping(value = {"listfurniture/addfurniture/{id}"})
    public String saveFurniture (Model model,@PathVariable("id")int id, @ModelAttribute("furnitureform") FurnitureForm furnitureForm ) {
        String title = furnitureForm.getTitle();
        int price = furnitureForm.getPrice();
        Categories categories=categoryService.findById(id);

        if (title != null && price != 0) {
            Furnitures newFurniture = new Furnitures();
            newFurniture.setTitle(title);
            newFurniture.setPrice(price);
            newFurniture.setCategories(categories);
            furnitureService.save(newFurniture);
            return "redirect:/listfurniture/"+id;
        } else
            model.addAttribute("errorMessage", errorMessage);
        return "listfurniture";
    }

    @GetMapping(value = {"listfurniture/deletef/{id}"})
    public String deleteFurniture ( @PathVariable(value = "id") int id,HttpServletRequest request ) {

        furnitureService.remove(furnitureService.findById(id));

        return "redirect:"+request.getHeader("Referer");
    }
}
