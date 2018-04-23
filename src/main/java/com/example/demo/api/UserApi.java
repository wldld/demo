package com.example.demo.api;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        return userService.login(username, password);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(String username, String password, String email, int age) throws Exception{
        return userService.addUser(username, password, email, age);
    }

}
