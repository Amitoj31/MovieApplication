package com.niit.favouriteservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.OK, reason = "User Already exists")
public class UserAlreadyExistingException extends Exception{
}
