package com.example.arkadiusz.app.endpoints;

import com.example.arkadiusz.app.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserEndpoint
    {
    @Autowired
    UserDao userDao;

    @GetMapping("/user")
    public ResponseEntity<?> getUser()
        {
        return ResponseEntity.ok("123");
        }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> error()
        {
        return ResponseEntity.badRequest().build();
        }

    }
