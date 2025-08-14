package com.TrainTicketBooking.controller;

import com.TrainTicketBooking.passeger.Passanger;
import com.TrainTicketBooking.service.BookingService;
import com.TrainTicketBooking.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UIController {

    @Autowired
    private BookingService service;

    @GetMapping("/book")
    public String showForm(Model model) {
        model.addAttribute("passenger", new Passanger());
        model.addAttribute("trains", service.getAvailableTrains());
        return "index";  // loads templates/index.html
    }

    @PostMapping("/ticket")
    public String bookTicket(@ModelAttribute Passanger passenger, Model model) {
        Ticket ticket = service.bookTicket(passenger);
        model.addAttribute("ticket", ticket);
        return "ticket-success";  // loads templates/ticket-success.html
    }

    @GetMapping("/")
    public String showBookingForm(Model model) {
        model.addAttribute("passenger", new Passanger());
        model.addAttribute("trains", service.getAvailableTrains()); // adjust service as needed
        return "index"; // your booking form page
    }

}
