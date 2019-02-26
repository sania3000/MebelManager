package com.Sydorenko.service;

import com.Sydorenko.dao.CategoryRepository;
import com.Sydorenko.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
   CategoryRepository categoryRepository;

    @Override
    public List<Categories> getAll () {
        return  categoryRepository.findAll();
    }

    @Override
    public Categories findByCategory ( String category ) {
        return categoryRepository.findByCategory(category);
    }

    @Override
    public Categories save ( Categories categories ) {
        return  categoryRepository.save(categories);
    }

    @Override
    public Categories findById ( int id ) {
        return categoryRepository.findById(id);
    }

    @Override
    public void remove ( Categories categories ) {
    categoryRepository.delete(categories);
    }

//    @Override
//    public void update (String category, int id ) {
//        categoryRepository.updateCategories(category,id);

//    }



}
