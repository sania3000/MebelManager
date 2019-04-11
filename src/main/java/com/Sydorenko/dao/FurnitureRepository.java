package com.Sydorenko.dao;

import com.Sydorenko.model.Categories;
import com.Sydorenko.model.Furnitures;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/** The class is a part of the application DAO layer. The purpose of it is
 * an interaction between the application and the database. It provides methods
 * for getting the furnitures objects from the database, saving and deleting
 * them.
 * @author Oleksandr Sydorenko
 */

@Repository
public interface FurnitureRepository extends CrudRepository<Furnitures,Long> {

    Furnitures findByTitle ( String title );

    Furnitures findById ( long id );

    List<Furnitures> findByCategories ( Categories categories );

    void delete ( Furnitures furnitures );


    @Override
    void deleteAll ( Iterable<? extends Furnitures> iterable );


}