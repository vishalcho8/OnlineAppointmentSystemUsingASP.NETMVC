package com.online.appointmentt.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.online.appointmentt.model.BookingDetail;
import com.online.appointmentt.service.BookingService;

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
    public ModelAndView bookapp(@ModelAttribute("bookingdetail") BookingDetail bookingdetail /*, @RequestParam Date booking_date */) {

		/* System.out.println("getIdByBookingDate booking date..." + booking_date);
		List<BookingDetail> bd = bookingService.getIdByBookingDate(booking_date);		
		if (bd == null) { 
			System.out.println("getIdByBookingDate..." + bd.size()); */
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
	     /*  } else {
	    	  
	    	System.out.println("getIdByBookingDate bd not null...");
	    	ModelAndView model = new ModelAndView("welcome");
	    	model.addObject("message", "Appointment is already booked for this time."); 
	    	return model;
	    } */
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
	
	@GetMapping("/updatebooking")
	public String showUpdateBookingPage(@RequestParam long id, ModelMap model) {

		BookingDetail bd = bookingService.findById(id).get();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String lv_date= formatter.format(bd.getBooking_date());
	    
	    System.out.println("updatebooking booking_date in controller..." + lv_date);
		System.out.println("updatebooking booking_id in controller..." + bd.getBooking_id());
		System.out.println("updatebooking booking_date in controller..." + bd.getBooking_date());
	    System.out.println("updatebooking booking_time_from in controller..." + bd.getBooking_time_from());
	    System.out.println("updatebooking booking_time_to in controller..." + bd.getBooking_time_to());
	    
        model.put("bookingdetail", bd);
        return "updatebooking";
    } 
	
	@PostMapping("/updatebooking")
	public ModelAndView updatebooking(@ModelAttribute("bookingdetail") BookingDetail bookingdetail) {
		ModelAndView model = new ModelAndView("admin");
		
		bookingService.save(bookingdetail);
		model.addObject("admin", bookingService.findAll());
		
        return model;
    }

	
}
