package com.example.arkadiusz.app.service;

import com.example.arkadiusz.app.entities.UserEntity;
import com.example.arkadiusz.app.exception.UserAlreadyExistException;

public interface UserService
    {

    Boolean registerUser(UserEntity entity) throws UserAlreadyExistException;

    Boolean userExist(UserEntity entity);

    UserEntity getUserById(Long id);
    }
