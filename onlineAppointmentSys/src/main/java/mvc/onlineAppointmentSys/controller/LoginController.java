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
public class LoginController {

	@Autowired
	LoginService loginService;
	
	   @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new LoginUser());

	    return mav; 
	  } 
	 
	 @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("login") LoginUser login) {
	    ModelAndView mav = null;
	    LoginUser user = loginService.validateUser(login);

	    if (user != null ) {
	      mav = new ModelAndView("welcome");
	      mav.addObject("firstname", user.getFirstname());
	      mav.addObject("bookingdetail", new BookingDetail());
	    } else { 
	      mav = new ModelAndView("login");
	      mav.addObject("message", "Username or Password is wrong!!");
	    }

	    return mav;
	  }

}
