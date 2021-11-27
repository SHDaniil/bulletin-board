package com.bbb.bulletinboard.services;

import com.bbb.bulletinboard.entities.User;
import com.bbb.bulletinboard.repositories.UserRepository;
import com.bbb.bulletinboard.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User read(UUID id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean update(User user, UUID id) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
        return true;
    }
}
