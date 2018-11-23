package com.niu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by ami on 2018/11/23.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) throws Exception {

        session.setAttribute("activeUser",username);
        return "redirect:/items/queryItems.action";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session)throws Exception{
        session.invalidate();
        return "redirect:/items/queryItems.action";
    }


}
