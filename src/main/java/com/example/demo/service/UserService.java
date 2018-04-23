package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    ObjectMapper om;

    public String login(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user != null) {
            return "success";
        }else {
            return "failed";
        }
    }

    public String addUser(String username, String password, String email, int age) throws Exception{
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setAge(age);
        userDao.save(newUser);
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", true);
        return om.writeValueAsString(response);
    }
}
