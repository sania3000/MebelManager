package com.Sydorenko.service;


import com.Sydorenko.model.Categories;
import com.Sydorenko.model.Furnitures;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FurnitureService {
    List<Furnitures> findAll();
    Furnitures findByTitle(String title);
    Furnitures save(Furnitures furnitures);

  List<Furnitures> findByCategory( Categories categories );
    Furnitures findById(int id );


}
