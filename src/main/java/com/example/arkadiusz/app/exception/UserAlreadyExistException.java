package com.example.arkadiusz.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "user already exist")
public class UserAlreadyExistException extends Exception
    {
    }
