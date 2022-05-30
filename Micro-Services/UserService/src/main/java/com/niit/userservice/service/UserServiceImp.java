package com.niit.userservice.service;



import com.niit.userservice.exception.UserAlreadyExistsException;
import com.niit.userservice.exception.UserNotFoundException;
import com.niit.userservice.model.User;
import com.niit.userservice.proxy.UserProxy;
import com.niit.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;
    private UserProxy userProxy;

    @Autowired
    public UserServiceImp(UserRepository userRepository,UserProxy userProxy )
    {
        this.userRepository=userRepository;
        this.userProxy=userProxy;
    }


    @Override
    public User saveUser(User user  ) throws UserAlreadyExistsException  {

            User result = userRepository.save(user);
            System.out.println(result);

            ResponseEntity response = userProxy.registeruser(result);

            System.out.println(response);
            return result;

    }
    @Override
    public boolean deleteUser(int id) {
        userRepository.deleteById(id);return true;
    }

    @Override
    public User updateUser(User user) {
        return  userRepository.save(user);
    }

    @Override
    public User checkemail(String email)  {
        User user =userRepository.findByEmail(email);
        if(user!=null)
        {
            return user;
        }
        else
        {
            return null;
        }
    }


    @Override
    public User authenticateUser(String email, String password) throws UserNotFoundException {
        User user =userRepository.findByEmailAndPassword(email,password);
        if(user!=null)
        {
            return user;
        }
        else
        {
            throw new UserNotFoundException();
        }
    }
    @Override
    public List<User> getallUser() {
        return userRepository.findAll();
    }
}
