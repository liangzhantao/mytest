package com.itheima.controller;

import com.itheima.entity.Users;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class userController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/save")
    public String save(Users user){
        int num = userService.save(user);
        if (num>0){
            return "redirect:/pages/login.jsp";
        }else {
            return "redirect:/pages/register.jsp";
        }
    }
   /* @RequestMapping("/doLogin")
    public String findByUser(String username,String password){
        Users byUser = userService.findByUser(username);
        System.out.println("++++++++++"+password);
        if (byUser.getPassword().equals(password)){
            return "redirect:/pages/success.jsp";
        }else{
            return "redirect:/pages/login.jsp";
        }
    }*/
 }
