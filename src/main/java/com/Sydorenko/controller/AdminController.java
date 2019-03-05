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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**Создаем контроллер для редактирования информации о товарах,право доступа имеет ADMIN

 */

@Controller
@PreAuthorize("hasAuthority('ADMIN')")  //редактирование разрешаем пользователю с правом доступа ADMIN
public class AdminController {
    @Autowired
    FurnitureService furnitureService;
    @Autowired
    CategoryService categoryService;
    @Value("${welcome.message}")
    private String message;
    @Value("${error.message}")
    private String errorMessage;


    @GetMapping(value = {"/categories"})     //отображаем страницу категорий
    public String categoryList ( Model model ) {
        model.addAttribute("categories", categoryService.getAll());
        CategoryForm categoryForm = new CategoryForm();
        model.addAttribute("categoryform", categoryForm);

        return "listcategories";
    }


    @PostMapping(value = {"addcategory"})       //добавляем новую категорию
    public String saveCategory ( Model model, @ModelAttribute("categoryform") CategoryForm categoryForm ) {


        String category = categoryForm.getCategory();


        if (category != null && !category.isEmpty()) {
            Categories newcategory = new Categories();
            newcategory.setCategory(category);

            categoryService.save(newcategory);

            return "redirect:/categories";      //перенаправляемся на страницу со списком категорий
        }
        model.addAttribute("errorMessage", errorMessage);
        return "listcategories";

    }
@GetMapping(value="/category/{categories}") //обновляем
public String editCategory(@PathVariable Categories categories,Model model) {
    model.addAttribute("categories",categories);
    return "categoryEdit";
}
@PostMapping(value = "/editcategory")
public String updateCategory(@RequestParam("id") Categories categories ,@RequestParam String category){
        categories.setCategory(category);
        categoryService.save(categories);
        return "redirect:/categories";
}

    @GetMapping(value = "/delete/{categories}")         //удаляем
    public String deleteCategory ( @PathVariable Categories categories ) {
        List<Furnitures> list = furnitureService.findByCategory(categories);
        furnitureService.deleteAll(list);               //начала удаляем всю furniture что есть в этой категории
        categoryService.remove(categories);

        return "redirect:/categories";
    }




    @GetMapping(value = {"furniture/{categories}"})              //делаем мапинг для фурнитуры
    public String furnitureList ( @PathVariable Categories categories, Model model ) {
        model.addAttribute("category",categories);
        model.addAttribute("furnitures", furnitureService.findByCategory(categories));

        FurnitureForm furnitureForm = new FurnitureForm();
        model.addAttribute("furnitureform", furnitureForm);

        return "listfurniture";
    }

    @PostMapping(value = {"furniture/addfurniture/{id}"})
    public String saveFurniture (Model model,@PathVariable("id")long id, @ModelAttribute("furnitureform") FurnitureForm furnitureForm ) {
        String title = furnitureForm.getTitle();
        int price = furnitureForm.getPrice();
        Categories categories=categoryService.findById(id);

        if (title != null && price != 0) {
            Furnitures newFurniture = new Furnitures();
            newFurniture.setTitle(title);
            newFurniture.setPrice(price);
            newFurniture.setCategories(categories);
            furnitureService.save(newFurniture);
            return "redirect:/furniture/"+id;
        } else
            model.addAttribute("errorMessage", errorMessage);
        return "furniture";
    }

    @GetMapping(value = {"furniture/delete/{id}"})
    public String deleteFurniture ( @PathVariable(value = "id") long id,HttpServletRequest request ) {

        furnitureService.remove(furnitureService.findById(id));

        return "redirect:"+request.getHeader("Referer");
    }
    @GetMapping(value = "/edit/{furnitures}")
    public String editFurniture(@PathVariable Furnitures furnitures,Model model){
        model.addAttribute("furnitures",furnitures);
        return "furnitureEdit";
    }
    @PostMapping(value = "/editfurniture")
    public String updateFurniture(@RequestParam("id") Furnitures furnitures,@RequestParam String title,@RequestParam int price,@RequestParam Categories categories ){
        furnitures.setTitle(title);
        furnitures.setPrice(price);
        furnitures.setCategories(furnitures.getCategories());
        furnitureService.save(furnitures);
        return "redirect:/furniture/"+categories.getId();
    }
}
