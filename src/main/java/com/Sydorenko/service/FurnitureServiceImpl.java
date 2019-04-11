package com.Sydorenko.service;

import com.Sydorenko.dao.CategoryRepository;
import com.Sydorenko.dao.FurnitureRepository;
import com.Sydorenko.model.Categories;
import com.Sydorenko.model.Furnitures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/** This class is the FurnitureService interface implementation.
 * It consists of interface methods, overridden by means of
 * using corresponding methods of FurnitureRepository.
 * @author Oleksandr Sydorenko
 */

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
    public Furnitures findById ( long id ) {
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

    @Override
    public void remove ( Furnitures furnitures ) {
        furnitureRepository.delete(furnitures);
    }

    @Override
    public void deleteAll ( List<Furnitures> list ) {
        furnitureRepository.deleteAll(list);
    }
}
