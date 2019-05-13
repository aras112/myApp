package com.example.arkadiusz.app.service;

import com.example.arkadiusz.app.dao.UserDao;
import com.example.arkadiusz.app.entities.UserEntity;
import com.example.arkadiusz.app.exception.UserAlreadyExistException;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService
    {
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao)
        {
        this.userDao = userDao;
        }

    @Override
    public Boolean registerUser(UserEntity entity) throws UserAlreadyExistException
        {
        if (userDao.existsById(entity.getId()))
            {
            throw new UserAlreadyExistException();
            }

        userDao.save(entity);

        return true;
        }

    @Override
    public Boolean userExist(UserEntity entity)
        {
        return null;
        }

    @Override
    public UserEntity getUserById(Long id)
        {
        return null;
        }
    }
