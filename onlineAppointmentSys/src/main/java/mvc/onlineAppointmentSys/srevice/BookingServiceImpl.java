package mvc.onlineAppointmentSys.srevice;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.onlineAppointmentSys.model.BookingDetail;
import mvc.onlineAppointmentSys.repository.BookingRepo;

public class BookingServiceImpl implements BookingService {
	
	@Autowired
	public BookingRepo bookingrepo;
	public int insertAppointment(BookingDetail bookingdetail) {
	    return bookingrepo.insertAppointment(bookingdetail);

}
	public BookingDetail validateAppt(BookingDetail bookingdetail) {
	    return bookingrepo.validateAppt(bookingdetail);
}
}
