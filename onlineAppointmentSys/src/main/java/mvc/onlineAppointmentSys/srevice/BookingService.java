package mvc.onlineAppointmentSys.srevice;

import mvc.onlineAppointmentSys.model.BookingDetail;

public interface BookingService {
	
	int insertAppointment(BookingDetail bookingdetail);
	BookingDetail validateAppt(BookingDetail bookingdetail);
}
