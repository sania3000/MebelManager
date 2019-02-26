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

@Repository
public interface CategoryRepository extends CrudRepository<Categories,Long> {
    List<Categories> findAll();
    Categories findByCategory(String category);
    Categories save(Categories categories);

    Categories findById ( int id );

    @Override
    void delete ( Categories categories );

//@Query("update Categories u set u.category =:newCategory where u.id:=id")
//    Stream updateCategories(@Param("newCategory") String category,@Param("id")int id );

}
