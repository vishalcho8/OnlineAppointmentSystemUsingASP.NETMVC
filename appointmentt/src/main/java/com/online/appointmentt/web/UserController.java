package com.online.appointmentt.web;

import com.online.appointmentt.model.BookingDetail;
import com.online.appointmentt.model.User;
import com.online.appointmentt.service.SecurityService;
import com.online.appointmentt.service.UserService;
import com.online.appointmentt.validator.UserValidator;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public ModelAndView welcome(@ModelAttribute("bookingdetail") BookingDetail bookingdetail) {
    	//model.addAttribute("bookingdetail", new BookingDetail());
    	ModelAndView model = new ModelAndView("welcome");
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
 	    String lv_date= formatter.format(new Date()); 
 	    
 	    System.out.println("booking date tem in user control.." + lv_date);
    	model.addObject("booking_date_temp", lv_date);
        return model;
    }
}
