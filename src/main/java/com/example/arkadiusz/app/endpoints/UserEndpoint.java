package com.example.arkadiusz.app.endpoints;

import com.example.arkadiusz.app.dao.UserDao;
import com.example.arkadiusz.app.entities.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserEndpoint
    {
    @Autowired
    UserDao userDao;

    @GetMapping("/user")
    public ResponseEntity<UserEntity> getUser()
        {
        UserEntity userEntity =
                UserEntity.builder().email("11@11.pl").login("aras").role("123").password("aras").build();
        userDao.save(userEntity);

        return ResponseEntity.ok(userEntity);
        }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Integer error()
        {
        return 1;
        }

    }
