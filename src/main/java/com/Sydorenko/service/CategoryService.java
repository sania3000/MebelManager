package com.Sydorenko.service;

import com.Sydorenko.model.Categories;
/** This interface is a service interface. It is an intermediary
 * between DAO class and controller. It declares general actions
 * can be performed to the Category objects and which reproduce the
 * repository methods.
 * @author Oleksandr Sydorenko
 */

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
