package com.example.controller;

import com.example.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/users")
public class Users {

    @RequestMapping(method = RequestMethod.GET)
    List<User> getAll() {
        User jane = new User(1L, "Jane");
        User john = new User(2L, "John");
        return Arrays.asList(jane, john);
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/jane", method = RequestMethod.GET)
    void get() {
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(method = RequestMethod.PUT)
    void put() {
    }

    @RequestMapping(value = "/jane", method = RequestMethod.POST)
    User post(@RequestBody User user) {
        return user;
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/jane", method = RequestMethod.DELETE)
    void delete() {
    }

}
