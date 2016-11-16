package com.example.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class ConfigController {


    @RequestMapping(value = "/config", method = RequestMethod.GET)
    ResponseEntity get() {
        CacheControl cacheControl =
                CacheControl.maxAge(10, TimeUnit.MINUTES)
                        .cachePublic();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setCacheControl(cacheControl.getHeaderValue());

        return new ResponseEntity("This value to be cached",
                responseHeaders, HttpStatus.OK);
    }

}
