package com.springboot.staticresource.controller;

import com.springboot.staticresource.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LearnController {
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(userName + " " + password);
        if(!userName.equals("") && password != ""){
            User user = new User(userName,password);
            request.getSession().setAttribute("user",user);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
    }
    @RequestMapping(value = "/learn",method = RequestMethod.GET)
    public String logined(){
        return "learn";
    }
}
