package mvc.onlineAppointmentSys.model;

import java.util.Date;

/* import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; */

//@Entity
public class BookingDetail {
	/* @Id
	@GeneratedValue(strategy = GenerationType.AUTO) */
	int lv_bookingid = (int)System.nanoTime();
	private int booking_id = Math.abs(lv_bookingid);
	private String name;
	private String email;
	private long phone;
	private Date booked_on;
	private Date booking_date;
	private String booking_time_from;
	private String booking_time_to; 
	private String error_message;
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	} 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Date getBooked_on() {
		return booked_on;
	}
	public void setBooked_on(Date lv_booked_on) {
		this.booked_on = lv_booked_on;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public String getBooking_time_from() {
		return booking_time_from;
	}
	public void setBooking_time_from(String booking_time_from) {
		this.booking_time_from = booking_time_from;
	}
	public String getBooking_time_to() {
		return booking_time_to;
	}
	public void setBooking_time_to(String booking_time_to) {
		this.booking_time_to = booking_time_to;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

}
