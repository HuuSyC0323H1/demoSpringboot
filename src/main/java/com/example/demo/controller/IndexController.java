package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/home/")
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    protected DepartmentService departmentService;
    @Autowired
    private JobService jobService;
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public ModelAndView home(@RequestParam(value = "keyword", required = false) String keyword, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("all-admin-index");
        Page<User> userPage;
        Page<Customer> customerPage;
        if (keyword != null && !keyword.isEmpty()) {
            userPage = userService.searchAllBy(keyword, pageable);
        } else {
            userPage = userService.findAll(pageable);
        }
        customerPage = customerService.findAll(pageable);
        List<User> users = userPage.getContent();
        List<Customer> customers = customerPage.getContent();
        List<Order> orders = orderService.findTop5ByOrderByStartDayDesc(pageable);
        List<Job> jobs = jobService.findTop5Job(pageable);
        Long countOrder = orderService.count();
        Long countJob = jobService.countJob();
        Long countCustomer = customerService.count();
        modelAndView.addObject("job",new Job());
        modelAndView.addObject("users", users);
        modelAndView.addObject("customers",customers);
        modelAndView.addObject("jobs",jobs);
        modelAndView.addObject("countOrder",countOrder);
        modelAndView.addObject("countJob",countJob);
        modelAndView.addObject("countCustomer",countCustomer);
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }

    @GetMapping("/home1")
    public ModelAndView home1(@RequestParam(value = "keyword1", required = false) String keyword, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("all-admin-index");
        Page<User> usersPage;
        Page<Customer> userPage1;
        if (keyword != null && !keyword.isEmpty()) {
            userPage1 = customerService.searchAllBy(keyword, pageable);
        } else {
            userPage1 = customerService.findAll(pageable);
        }
        usersPage = userService.findAll(pageable);
        List<User> users = usersPage.getContent();
        List<Customer> customers = userPage1.getContent();
        modelAndView.addObject("users", users);
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("/data")
    public ModelAndView data(@RequestParam(value = "keyword", required = false) String keyword, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("all-admin-datalist");
        Page<User> userPage11;
        Page<Customer> userPage1;
        Page<Department> departmentPage;
        if (keyword != null && !keyword.isEmpty()) {
            userPage11 = userService.searchAllBy(keyword, pageable);
            userPage1 = customerService.searchAllBy(keyword,pageable);
            departmentPage= departmentService.searchAllBy(keyword,pageable);
        } else {
            userPage11 = userService.findAll(pageable);
            userPage1 = customerService.findAll(pageable);
            departmentPage = departmentService.findAll(pageable);
        }
        List<User> users = userPage11.getContent();
        List<Customer> customers = userPage1.getContent();
        List<Department> departments = departmentPage.getContent();
        modelAndView.addObject("user", new User());
        modelAndView.addObject("department",departments);
        modelAndView.addObject("users", users);
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/login")
    public String user(Model model) {
        model.addAttribute("null");
        return "all-admin-login";
    }

    @GetMapping("/register")
    public String employee() {
        return "all-admin-register";
    }
}
