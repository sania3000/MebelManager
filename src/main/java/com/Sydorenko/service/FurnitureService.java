package com.Sydorenko.service;


import com.Sydorenko.model.Categories;
import com.Sydorenko.model.Furnitures;

import java.util.List;
import java.util.Optional;

public interface FurnitureService {
    List<Furnitures> findAll();
    Furnitures findByTitle(String title);
    Furnitures save(Furnitures furnitures);

  List<Furnitures> findByCategory( Categories categories );
    Furnitures findById( long id );
    void remove(Furnitures furnitures);
        void deleteAll(List<Furnitures> list);



}
