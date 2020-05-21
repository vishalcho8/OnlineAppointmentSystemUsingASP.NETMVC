package mvc.onlineAppointmentSys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.onlineAppointmentSys.model.BookingDetail;
import mvc.onlineAppointmentSys.model.LoginUser;
import mvc.onlineAppointmentSys.srevice.LoginService;

@Controller
public class RegisterController {
	 @Autowired
	  public LoginService loginService;

	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("loginuser", new LoginUser());

	    return mav;
	  }

	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("loginuser") LoginUser loginuser) {

		  ModelAndView mav = null;
		  LoginUser user = null;
		  user = loginService.validateRegister(loginuser);
		  System.out.println("validate register.." + user.getErr_message());
		  if (user.getErr_message() == null) {
			  user = null;
			  user = loginService.validateEmail(loginuser);
			  System.out.println("validate email.." + user.getErr_message());
			  if (user.getErr_message() == null) {
				  loginService.register(loginuser);
			  
				  mav = new ModelAndView("welcome");
				  mav.addObject("firstname", loginuser.getFirstname());
				  mav.addObject("bookingdetail", new BookingDetail());
				  } else  {
				    	 mav = new ModelAndView("register");
				    	 mav.addObject("message", "Email already registered.");
				  }
		  
	     } else {
	    	 mav = new ModelAndView("register");
	    	 mav.addObject("message", "Username is already taken. Please choose different username.");
	     } 
	     
		  return mav;
	  }

}
