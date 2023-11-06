package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.impl.CustomerService;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class dataController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/home/save")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/home/data";
    }

    @GetMapping("/home/data/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> user = userService.findbyID(id);
        if (user.isPresent()) {
            userService.delete(id);
        } else {
            modelAndView.setViewName("all-admin-404");
        }
        return "redirect:/home/data";
    }
    @GetMapping("/home/update/{id}")
    public ModelAndView editUser(@PathVariable("id") Long id) {
        Optional<User> user = userService.findbyID(id);
        if (user.isPresent()){
            ModelAndView modelAndView = new ModelAndView("all-admin-datalist");
            modelAndView.addObject("user",user.get());
            return modelAndView;
        }
        return new ModelAndView("all-admin-404");
    }
    @PostMapping("/home/update")
    public String saveUserChanges(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/home/data";
    }
}
