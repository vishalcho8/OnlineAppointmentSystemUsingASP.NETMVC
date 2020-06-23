package com.online.appointmentt.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online.appointmentt.model.BookingDetail;
import com.online.appointmentt.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
    private BookingRepository bookingRepository;
	
	@Override
    public BookingDetail save(BookingDetail dookingdetail) {
        return bookingRepository.save(dookingdetail);
    }
	
	@Override
    public List <BookingDetail> findAll() {
        return bookingRepository.findAll();
    }
	
	
    
	@Override
    public void deleteById(long id) {
		System.out.println("delete by id no..." + id);
		Optional <BookingDetail> bd = bookingRepository.findById(id);
	    if (bd.isPresent()) {
	    	bookingRepository.delete(bd.get());
	    }
    }	
	
	/* @Override
    public BookingDetail validateBooking() {
		
        return bookingRepository.validateBooking();
    } */
	
}
