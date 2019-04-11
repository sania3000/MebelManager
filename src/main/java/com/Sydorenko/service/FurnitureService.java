package com.Sydorenko.service;


import com.Sydorenko.model.Categories;
import com.Sydorenko.model.Furnitures;

import java.util.List;
/** This interface is a service interface. It is an intermediary
 * between DAO class and controller. It declares general actions
 * can be performed to the Furniture objects and which reproduce the
 * repository methods.
 * @author Oleksandr Sydorenko
 */

public interface FurnitureService {
    List<Furnitures> findAll();
    Furnitures findByTitle(String title);
    Furnitures save(Furnitures furnitures);

  List<Furnitures> findByCategory( Categories categories );
    Furnitures findById( long id );
    void remove(Furnitures furnitures);
        void deleteAll(List<Furnitures> list);



}
