package com.Sydorenko.dao;

import com.Sydorenko.model.Categories;
import org.apache.el.stream.Stream;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/** The class is a part of the application DAO layer. The purpose of it is
 * an interaction between the application and the database. It provides methods
 * for getting the categories objects from the database, saving and deleting
 * them.
 * @author Oleksandr Sydorenko
 */
@Repository
public interface CategoryRepository extends CrudRepository<Categories,Long> {
    List<Categories> findAll();
    Categories findByCategory(String category);
    Categories save(Categories categories);

    Categories findById ( long id );

    @Override
    void delete ( Categories categories );



}
