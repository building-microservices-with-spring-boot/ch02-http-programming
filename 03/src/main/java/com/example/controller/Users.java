package com.example.controller;

import com.example.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.List;


@Controller
public class Users {

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<User> getAll() {
        User jane = new User(1L, "Jane");
        User john = new User(2L, "John");
        return Arrays.asList(jane, john);
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/users/jane", method = RequestMethod.GET)
    void get() {
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    void put() {
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/users/jane", method = RequestMethod.POST)
    void post() {
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @RequestMapping(value = "/users/jane", method = RequestMethod.DELETE)
    void delete() {
    }

}
