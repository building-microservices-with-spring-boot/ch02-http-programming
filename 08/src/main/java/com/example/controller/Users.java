package com.example.controller;

import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class Users {

    Logger logger = LoggerFactory.getLogger(Users.class);

    @RequestMapping(method = RequestMethod.GET)
    List<User> getAll(@RequestParam(value = "page", required = false) Integer page,
                      @RequestParam(value = "size", required = false) Integer size) {

        logger.info(String.format("Requested all users with page" +
                " %d and size %d ", page, size));

        User jane = new User(1L, "Jane");
        User john = new User(2L, "John");
        return Arrays.asList(jane, john);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    User get(@PathVariable String username) {
        return new User(1L, username);
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(method = RequestMethod.PUT)
    void put() {
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    User post(@RequestBody User user, @PathVariable String username) {
        return user;
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    void delete(@PathVariable String username) {
    }

}
