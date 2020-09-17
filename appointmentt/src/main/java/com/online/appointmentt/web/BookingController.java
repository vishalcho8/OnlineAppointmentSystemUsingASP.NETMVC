package com.online.appointmentt.web;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.online.appointmentt.model.BookingDetail;
import com.online.appointmentt.repository.BookingRepository;
import com.online.appointmentt.service.BookingService;
import com.online.appointmentt.validator.UserValidator;

@Controller
public class BookingController {
	
	@Autowired
	BookingService bookingService;

	// This will convert booking date which we have selected for appointment to yyyy-mm-dd.
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	    //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@PostMapping("/bookingProcess")
    public ModelAndView bookapp(@ModelAttribute("bookingdetail") BookingDetail bookingdetail ,
    								@RequestParam Date booking_date,
    								@DateTimeFormat(iso = ISO.DATE) LocalDate date,
    								@RequestParam String booking_time_from , 
    								@RequestParam String booking_time_to ,
    								Authentication authentication) {
		
			
			bookingdetail.setUsername(authentication.getName());
			System.out.println("get User name in booking controller..." + bookingdetail.getUsername());
	        float lv_timefrom = Float.parseFloat(bookingdetail.getBooking_time_from());
	    	float lv_timeto = Float.parseFloat(bookingdetail.getBooking_time_to());
	    	
	    	System.out.println("lv_timefrom in booking controller..." + lv_timefrom);
	    	System.out.println("lv_timeto in booking controller..." + lv_timeto);
	    	
	        if (lv_timefrom >= lv_timeto) {
	        	System.out.println("Time from should be less than time to......");
	        	ModelAndView model = new ModelAndView("welcome"); 
	        	model.addObject("message", "Appointment Time from should be less than time to."); 
	            return model;
	        }
	        
	    
	        
		List<BookingDetail> bd = bookingService.getIdByBookingDate(booking_date, booking_time_from, booking_time_to);		
		if (bd.size() == 0 ) { 
			System.out.println("getIdByBookingDate sixe null..." + bd.size());
			ModelAndView model = new ModelAndView("summary");
	        bookingService.save(bookingdetail);
	        
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    String lv_date= formatter.format(bookingdetail.getBooking_date()); 
		    
	        model.addObject("booking_id", bookingdetail.getBooking_id());
	        model.addObject("name", bookingdetail.getName());
		    model.addObject("booking_date", lv_date);
		    model.addObject("booking_time_from", bookingdetail.getBooking_time_from());
		    model.addObject("booking_time_to", bookingdetail.getBooking_time_to());
		    model.addObject("phone", bookingdetail.getPhone()); 
		    return model;
	       } else {
	    	  
	    	System.out.println("getIdByBookingDate bd not null...");
	    	System.out.println("getIdByBookingDate..." + bd.size()); 
	    	ModelAndView model = new ModelAndView("welcome");
	    	model.addObject("message", "Appointment is already booked for this time."); 
	    	return model;
	    } 
    }
	
	@GetMapping("/admin")
	public ModelAndView welcome(@ModelAttribute("bookingdetail") BookingDetail bookingdetail) {
		ModelAndView model = new ModelAndView("admin");
    	model.addObject("admin", bookingService.findAll());
    	System.out.println("after find all call...");
        return model;
    }
	
	@GetMapping("/delete")
	public ModelAndView deleteappt(@ModelAttribute("bookingdetail") BookingDetail bookingdetail
			, @RequestParam long id) {
		ModelAndView model = new ModelAndView("admin");
		System.out.println("delete id in controller..." + id);
		bookingService.deleteById(id);
    	model.addObject("admin", bookingService.findAll());
    	
        return model;
    }
	
	@GetMapping("/deletemyapp")
	public ModelAndView deletemyappt(@ModelAttribute("bookingdetail") BookingDetail bookingdetail
			, @RequestParam long id
			, @RequestParam String username) {
		ModelAndView model = new ModelAndView("myappointment");
		System.out.println("delete my appointment id in controller..." + id);
		bookingService.deleteById(id);
    	model.addObject("myappointment", bookingService.getUserAppointment(username));
    	
        return model;
    }
	
	@GetMapping("/updatebookingmyapp")
	public String showUpdateBookingPagemyapp(@RequestParam long id, ModelMap model
										) {

		BookingDetail bd = bookingService.findById(id).get();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String lv_date= formatter.format(bd.getBooking_date());
	    
	    //Traces to check for values
	    System.out.println("updatebooking booking_date in controller..." + lv_date);
		System.out.println("updatebooking booking_id in controller..." + bd.getBooking_id());
		System.out.println("updatebooking booking_date in controller..." + bd.getBooking_date());
	    System.out.println("updatebooking booking_time_from in controller..." + bd.getBooking_time_from());
	    System.out.println("updatebooking booking_time_to in controller..." + bd.getBooking_time_to());
	    
        model.put("bookingdetail", bd);
        return "updatebooking";
    } 
	
	@PostMapping("/updatebookingmyapp")
	public ModelAndView updatebookingmyapp(@ModelAttribute("bookingdetail") BookingDetail bookingdetail,
									Authentication authentication , 
									@RequestParam String username) {
		
		bookingdetail.setUsername(authentication.getName());
		System.out.println("get User name in booking controller..." + bookingdetail.getUsername());
		ModelAndView model = new ModelAndView("myappointment");
		
		bookingService.save(bookingdetail);
		model.addObject("myappointment", bookingService.getUserAppointment(username));
		
        return model;
    }
	
	@GetMapping("/updatebooking")
	public String showUpdateBookingPage(@RequestParam long id, ModelMap model
										) {

		BookingDetail bd = bookingService.findById(id).get();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String lv_date= formatter.format(bd.getBooking_date());
	    
	    //Traces to check for values
	    System.out.println("updatebooking booking_date in controller..." + lv_date);
		System.out.println("updatebooking booking_id in controller..." + bd.getBooking_id());
		System.out.println("updatebooking booking_date in controller..." + bd.getBooking_date());
	    System.out.println("updatebooking booking_time_from in controller..." + bd.getBooking_time_from());
	    System.out.println("updatebooking booking_time_to in controller..." + bd.getBooking_time_to());
	    
        model.put("bookingdetail", bd);
        return "updatebooking";
    } 
	
	@PostMapping("/updatebooking")
	public ModelAndView updatebooking(@ModelAttribute("bookingdetail") BookingDetail bookingdetail,
									Authentication authentication) {
		
		bookingdetail.setUsername(authentication.getName());
		System.out.println("get User name in booking controller..." + bookingdetail.getUsername());
		ModelAndView model = new ModelAndView("admin");
		
		bookingService.save(bookingdetail);
		model.addObject("admin", bookingService.findAll());
		
        return model;
    }
	
	@GetMapping("/myappointment")
	public ModelAndView myappointment(@ModelAttribute("bookingdetail") BookingDetail bookingdetail , 
										@RequestParam String username
										) {
		
		ModelAndView model = new ModelAndView("myappointment");
		List<BookingDetail> bd = bookingService.getUserAppointment(username);		
		if (bd.size() == 0 ) { 
			System.out.println("getUserAppointment sixe null..." + bd.size());
			model.addObject("message", "You Don't have any appointment scheduled."); 
	    	return model; 
	    } 
		else {
				model.addObject("myappointment", bd);
				System.out.println("getUserAppointment sixe not null..." + bd.size());
	    		return model;
	    	}
	    }
    }
