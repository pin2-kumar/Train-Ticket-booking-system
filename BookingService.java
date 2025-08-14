package com.TrainTicketBooking.service;

import java.util.Map;

import com.TrainTicketBooking.passeger.Passanger;
import com.TrainTicketBooking.ticket.Ticket;

public interface BookingService {

	
	public Ticket bookTicket(Passanger passenger);
	
	public  Ticket getTicket(Integer TicketNumber);

	Map<Integer, String> getAvailableTrains();

	
}
