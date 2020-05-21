package mvc.onlineAppointmentSys.srevice;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.onlineAppointmentSys.model.BookingDetail;
import mvc.onlineAppointmentSys.repository.BookingRepo;

public class BookingServiceImpl implements BookingService {
	
	@Autowired
	public BookingRepo bookingRepo;
	public int insertAppointment(BookingDetail bookingdetail) {
	    return bookingRepo.insertAppointment(bookingdetail);

}
	public BookingDetail validateAppt(BookingDetail bookingdetail) {
	    return bookingRepo.validateAppt(bookingdetail);
}
}
