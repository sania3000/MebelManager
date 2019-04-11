package com.Sydorenko.dao;

import com.Sydorenko.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/** The class is a part of the application DAO layer. The purpose of it is
 * an interaction between the application and the database. It provides methods
 * for getting Users from the database, saving and deleting
 * them.
 * @author Oleksandr Sydorenko
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();
User findByEmail(String email);
User findById(long id);
void delete(User user);

}
