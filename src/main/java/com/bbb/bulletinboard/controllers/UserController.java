package com.bbb.bulletinboard.controllers;

import com.bbb.bulletinboard.entities.User;
import com.bbb.bulletinboard.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/api/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping ("{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") UUID id) {
        User user = userService.read(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<User>> read() {
        List<User> users = userService.readAll();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, @RequestBody User user) {
        boolean updated = userService.update(user, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id) {
        boolean deleted = userService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
