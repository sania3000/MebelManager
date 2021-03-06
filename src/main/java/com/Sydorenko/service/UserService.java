package com.Sydorenko.service;

import com.Sydorenko.model.User;


import java.util.List;

/**
 * @author Oleksandr Sydorenko
 * Интерфейс для взаимодействия с репозиторием.
 */
public interface UserService {
    List<User> getList();
    User findByEmail(String email);
    User save(User user);
    User findById(long id);
    void delete( User user );

}

