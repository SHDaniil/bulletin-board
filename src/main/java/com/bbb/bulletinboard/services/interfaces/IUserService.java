package com.bbb.bulletinboard.services.interfaces;

import com.bbb.bulletinboard.entities.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    void create(User user);
    User read(UUID id);
    List<User> readAll();
    boolean update(User user, UUID id);
    boolean delete(UUID id);
}
