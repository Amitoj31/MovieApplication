package com.niit.userservice.service;

import com.niit.userservice.model.User;

import java.util.Map;

public interface SecurityTokengenerator {
    public abstract Map<String,String> generateToken(User user);
}
