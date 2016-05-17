package com.example.controller;

import com.example.exception.ValidationException;
import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


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
    ResponseEntity<?> get(@PathVariable String username) {
        User user = new User(1L, username);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-RateLimit-Limit", "1000");
        responseHeaders.set("X-RateLimit-Remaining", "500");
        responseHeaders.set("X-RateLimit-Reset", "1457020923");
        return new ResponseEntity(user, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<?> put(@RequestBody User user) throws Exception {
        if (user.getUsername() != null && user.getUsername().length() < 5) {
            throw new ValidationException("User name is less than 5 character");
        } else {
            //create user first than
            return new ResponseEntity(user, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    User post(@RequestBody User user, @PathVariable String username) {
        return user;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    void delete(@PathVariable String username,
                @RequestHeader MultiValueMap<String, String> headers) {
        headers.forEach((k, v) -> logger.info(String.format("%s : %s ", k, v)));
        //here is where the user will be deleted
    }

}


