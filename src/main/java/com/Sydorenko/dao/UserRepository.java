package com.Sydorenko.dao;

import com.Sydorenko.model.Categories;
import com.Sydorenko.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();
User findByEmail(String email);
User findById(int id);
void delete(User user);

}
