package com.cvt.rest1.springbootrest1.controller;

import com.cvt.rest1.springbootrest1.ExceptionHandler.UserNotFoundException;
import com.cvt.rest1.springbootrest1.model.User;
import com.cvt.rest1.springbootrest1.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAOService service;

    //retrive all user details
    //GET /users
    @GetMapping(path = "/users")
    public List<User> getAllUser(){
        return service.findAll();
    }

    //retrive specific User by Id
    //Get /users/{Id}
    @GetMapping(path = "/users/{id}")
    public User getOneUser(@PathVariable int id){
        User user=service.findOne(id);
        //Exception handling
        if(user==null)
            throw new UserNotFoundException("Id-"+id);

        return user;
    }


    //input - details of user
    // return status code created & created as uri
    @PostMapping(path = "/users")
    public ResponseEntity addUser(@RequestBody  User user){

        User saveduser=service.save(user);
        //getting current uri loc
        //Created
        // /user/{id}  <--> saveduser.getId()

        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
         return   ResponseEntity.created(location).build();


    }

}
