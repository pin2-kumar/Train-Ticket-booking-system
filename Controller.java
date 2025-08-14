package com.TrainTicketBooking.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TrainTicketBooking.passeger.Passanger;
import com.TrainTicketBooking.service.BookingService;
import com.TrainTicketBooking.ticket.Ticket;

@RestController

public class Controller {

	
	@Autowired
	private BookingService service;

//           url = http://localhost:8080/swagger-ui/index.html

	@PostMapping(value = "/ticket", consumes = "application/json", produces = "application/json")
	
	public ResponseEntity<Ticket> ticketBooking(@RequestBody Passanger passenger) {
	    Ticket ticket = service.bookTicket(passenger);
	    
	    return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	    
	}

	 @GetMapping(value = "/{ticketNumber}", produces = "application/json")
	    public ResponseEntity<Ticket> getTicketByNumber(@PathVariable("ticketNumber") Integer ticketNumber) {
	        Ticket ticket = service.getTicket(ticketNumber);
	        if (ticket != null) {
	            return ResponseEntity.ok(ticket);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	 }
	 
	 
	 @GetMapping("/trains")
	    public ResponseEntity<Map<Integer, String>> getAllTrains() {
	        return new ResponseEntity<>(service.getAvailableTrains(), HttpStatus.OK);
	    }

	
}
