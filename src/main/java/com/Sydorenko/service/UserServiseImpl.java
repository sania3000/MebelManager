package com.Sydorenko.service;

import com.Sydorenko.dao.UserRepository;
import com.Sydorenko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiseImpl implements UserService {
    @Autowired
private UserRepository userRepository;

    @Override
    public List<User> getList () {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByEmail ( String email ) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save ( User user ) {
        return userRepository.save(user);
    }

    @Override
    public User findById ( int id ) {
        return userRepository.findById(id);
    }

    @Override
    public void delete ( User user ) {
        userRepository.delete(user);
    }
}
