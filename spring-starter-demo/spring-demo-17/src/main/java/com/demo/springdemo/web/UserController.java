package com.demo.springdemo.web;

import com.demo.springdemo.domain.User;
import com.demo.springdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public ModelAndView firstView() {
        ModelAndView mav = new ModelAndView("greet");
        // must match the jsp page name which is being requested.
        mav.addObject("greeting", "GeeksForGeeks Welcomes you to Spring!");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(User user) {
        userService.createUser(user);
        ModelAndView mav = new ModelAndView();

        mav.setViewName("user/createSuccess");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, params = "!myParam")
    public String register(@ModelAttribute("user") User user) {
        log.info("register user");
        return "user/register";
    }

    @RequestMapping("/{userId}")
    public ModelAndView showDetail(@PathVariable("userId") String userId) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("user/showDetail");
        mav.addObject("user", userService.getUserById(userId));
        return mav;
    }

}
