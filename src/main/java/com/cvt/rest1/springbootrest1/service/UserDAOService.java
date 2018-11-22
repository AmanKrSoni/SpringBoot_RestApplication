package com.cvt.rest1.springbootrest1.service;

import com.cvt.rest1.springbootrest1.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {
    private static int userCount=3;
    private static List<User> users=new ArrayList<>();

    static{
        users.add(new User(1,"Aman",new Date()));
        users.add(new User(2,"Anil",new Date()));
        users.add(new User(3,"Naveen",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }

        return null;
    }
}