package com.example.restapiapplication.controller;

import com.example.restapiapplication.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping
    public String home() {
        return "Hello";
    }

//    @RequestMapping(value="/user",method= RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User user=new User();
        user.setUserId(1);
        user.setUserName("Vishnu");
        user.setUserEmail("vishnu@gmail.com");
        return user;
    }

    @GetMapping("/user/{id}/{id2}")
    public String pathVariable(@PathVariable("id") String userId,
                               @PathVariable("id2") String appId){

        return "the value entered by user is "+userId+" "+appId;

    }

    @GetMapping("/reqparam")
    public String requestParams(@RequestParam String name,
                                @RequestParam(name="email",required = false,defaultValue = "xyz@gmail.com") String email){
        return "the request parameters are "+name+" "+email;
    }
}
