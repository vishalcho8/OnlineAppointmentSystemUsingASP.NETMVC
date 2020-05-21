package mvc.onlineAppointmentSys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.onlineAppointmentSys.model.BookingDetail;
import mvc.onlineAppointmentSys.srevice.BookingService;

@Controller
public class BookingController {
	Date lv_date = null;
	@Autowired
	BookingService bookingService;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	    //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = "/bookingProcess", method = RequestMethod.POST)
	  public ModelAndView bookingProcess(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("bookingdetail") BookingDetail bookingdetail) {
	    ModelAndView mavsummary = null;
	    BookingDetail bd = null;
	    bd =  bookingService.validateAppt(bookingdetail);
	    
	    if (bd.getError_message() == "Date null" ) {
	    	System.out.println("return to welcome page as date null..");
	    	mavsummary = new ModelAndView("welcome");
	    	mavsummary.addObject("message", "Please select appointment date." );
	    } else if (bd.getError_message() == "Time Error") {
	    	System.out.println("return to welcome page as time error..");
	    	mavsummary = new ModelAndView("welcome");
	    	mavsummary.addObject("message", "Error while validating time. Please check the following."
	    			+ " 1. Appointment time from is less than appointment time to."
	    			+ " 2. Appointment time to is greater than appointment time from."
	    			+ " 3. Appointment time from and appointment time to is not equal.");
	    } else if (bd.getError_message() == "Already booked") {
	    	System.out.println("return to welcome page as already booked..");
	    	mavsummary = new ModelAndView("welcome");
	    	mavsummary.addObject("message", "Appointment is already booked for this time."
	    			+" Please choose different time slot." );
	    } else if (bd.getError_message() == "Date in past") {
	    	System.out.println("return to welcome page as already booked..");
	    	mavsummary = new ModelAndView("welcome");
	    	mavsummary.addObject("message", "Appointment date should be greater than today." );
	    }
	    else { 
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  
		    String lv_date= formatter.format(bookingdetail.getBooking_date());  
		    bookingService.insertAppointment(bookingdetail);
		    mavsummary = new ModelAndView("summary");
		    mavsummary.addObject("booking_id", bookingdetail.getBooking_id());
		    mavsummary.addObject("name", bookingdetail.getName());
		    System.out.println("lv_date while sending..." + lv_date );
		    mavsummary.addObject("booking_date", lv_date );
		   // mavsummary.addObject("booking_date", bookingdetail.getBooking_date());
		    mavsummary.addObject("booking_time_from", bookingdetail.getBooking_time_from());
		    mavsummary.addObject("booking_time_to", bookingdetail.getBooking_time_to());
		    mavsummary.addObject("phone", bookingdetail.getPhone());
		    }
	    return mavsummary; 
	  }

}
