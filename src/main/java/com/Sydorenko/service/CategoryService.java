package com.Sydorenko.service;

import com.Sydorenko.model.Categories;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {
List<Categories> getAll();
Categories findByCategory(String category);
Categories save(Categories categories);
Categories findById(long id);
void remove(Categories categories);
//@Transactional
//void update(String category,int id);



}
