package com.niit.userservice.controller;


import com.niit.userservice.exception.UserAlreadyExistsException;
import com.niit.userservice.exception.UserNotFoundException;
import com.niit.userservice.model.Message;
import com.niit.userservice.model.User;
import com.niit.userservice.service.SecurityTokengenerator;
import com.niit.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/movieapp/authuser")
public class UserController {
    private UserService userService;
    private SecurityTokengenerator securityTokengenerator ;

    @Autowired
    public UserController(UserService userService,SecurityTokengenerator securityTokengenerator)
    {
        this.userService=userService;
        this.securityTokengenerator=securityTokengenerator;

    }
    @GetMapping("/user")
    public ResponseEntity<?> getallUsers()
    {
        return new ResponseEntity<>(userService.getallUser(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException
    {
        User resultuser=userService.checkemail(user.getEmail());
        System.out.println(resultuser);
        if(resultuser==null)
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
        else
        {
            throw new UserAlreadyExistsException();
        }
    }

    @DeleteMapping("/user/{id}")

    public ResponseEntity<?> deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
        return  new ResponseEntity<>(new Message("SUCCESS","RECORD DELETED"),HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<?>updateUser(@RequestBody User user)
    {

        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map = null;
        try {
            User resultuser = userService.authenticateUser(user.getEmail(), user.getPassword());
            System.out.print(user+"   "+user.getEmail()+user.getPassword());
            System.out.print(resultuser);
            if (resultuser.getEmail().equals(user.getEmail())) {
                map = securityTokengenerator.generateToken(resultuser);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);

        } catch (UserNotFoundException ex) {
            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("other exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
