package mvc.onlineAppointmentSys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.onlineAppointmentSys.model.AdminLoginUser;
import mvc.onlineAppointmentSys.srevice.AdminLoginService;



@Controller
public class AdminLoginController {
	@Autowired
	AdminLoginService adminLoginService;
	
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("adminlogin");
	    mav.addObject("adminlogin", new AdminLoginUser());

	    return mav; 
	  } 
	
	@RequestMapping(value = "/adminloginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("adminlogin") AdminLoginUser adminlogin) {
	    ModelAndView mav = null;
	    AdminLoginUser user = adminLoginService.validateAdmin(adminlogin);

	    if (user != null ) {
	      mav = new ModelAndView("adminview");
	      mav.addObject("message",  user.getFirstname());
	    } else { 
	      mav = new ModelAndView("adminlogin");
	      mav.addObject("message", "You are not admin!!");
	    }

	    return mav;
	  }
	 
}
