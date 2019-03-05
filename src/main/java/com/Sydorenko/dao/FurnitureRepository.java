package com.Sydorenko.dao;

import com.Sydorenko.model.Categories;
import com.Sydorenko.model.Furnitures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Stream;

@Repository
public interface FurnitureRepository extends CrudRepository<Furnitures,Long> {

Furnitures findByTitle(String title);

Furnitures findById ( long id );

List<Furnitures> findByCategories(Categories categories);

void delete(Furnitures furnitures);


    @Override
    void deleteAll ( Iterable<? extends Furnitures> iterable );


//@Transactional
//@Query("select f from Furnitures f where f.categories=:id ")
//    Stream<Furnitures> findByCategories( @Param ("id") Categories categories );
}
