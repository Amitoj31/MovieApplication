package com.niit.userservice.service;

import com.niit.userservice.exception.UserAlreadyExistsException;
import com.niit.userservice.exception.UserNotFoundException;
import com.niit.userservice.model.User;

import java.util.List;

public interface UserService {

    public abstract User saveUser(User user)throws UserAlreadyExistsException;
    public abstract boolean deleteUser(int id);
    public abstract User updateUser(User user);
    public abstract User checkemail(String email);

    public abstract User authenticateUser(String email, String password) throws UserNotFoundException;
    public abstract List<User> getallUser();
}
