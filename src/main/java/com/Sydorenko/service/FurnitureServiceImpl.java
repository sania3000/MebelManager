package com.Sydorenko.service;

import com.Sydorenko.dao.CategoryRepository;
import com.Sydorenko.dao.FurnitureRepository;
import com.Sydorenko.model.Categories;
import com.Sydorenko.model.Furnitures;
import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    @Autowired
    FurnitureRepository furnitureRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Furnitures> findAll () {
        return (List<Furnitures>) furnitureRepository.findAll();
    }

    @Override
    public Furnitures findByTitle ( String title ) {
        return furnitureRepository.findByTitle(title);
    }



    @Override
    public Furnitures findById ( int id ) {
        return furnitureRepository.findById(id);
    }

    @Override
    public Furnitures save ( Furnitures furnitures ) {
        return furnitureRepository.save(furnitures);
    }
@Transactional
    @Override
    public List<Furnitures> findByCategory ( Categories categories ) {
        return  furnitureRepository.findByCategories(categories);
    }
}
