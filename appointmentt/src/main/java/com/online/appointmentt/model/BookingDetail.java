package com.online.appointmentt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "booking_dets")
public class BookingDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long booking_id;
	
	private String name;
	private String email;
	private long phone;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date booked_on;
	
	private Date booking_date;
	private String booking_time_from;
	private String booking_time_to; 
	//private String error_message;
	public long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(long booking_id) {
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
	public void setBooked_on(Date booked_on) {
		this.booked_on = booked_on;
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
	

}
