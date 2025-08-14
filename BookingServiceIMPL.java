package com.TrainTicketBooking.IMPL;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import com.TrainTicketBooking.service.PdfGeneratorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainTicketBooking.passeger.Passanger;
import com.TrainTicketBooking.service.BookingService;
import com.TrainTicketBooking.service.EmailService;
import com.TrainTicketBooking.ticket.Ticket;

@Service
public class BookingServiceIMPL implements BookingService {

    private final Map<Integer, String> TrainMap = new HashMap<>();
    private final Map<Integer, Ticket> TicketMap = new HashMap<>();
    private Integer ticketNumber = 1;

    @Autowired
    private EmailService emailService;


    @Autowired
    private PdfGeneratorService pdfGeneratorService;


    public BookingServiceIMPL() {
        TrainMap.put(10028, "Rajdhani EXPRESS");
        TrainMap.put(28878, "Shatabdi EXPRESS");
        TrainMap.put(35685, "Duronto EXPRESS");
        TrainMap.put(12835, "HTE SMVB EXPRESS");
        TrainMap.put(20408, "ANVT RNC Express");
        TrainMap.put(12826, "SBP EXPRESS");
        TrainMap.put(12872, "Garib Rath");
        TrainMap.put(22826, "TEJAS RAJ EXPRESS");
        TrainMap.put(12816, "NANDAKANAN EXPRESS");
        TrainMap.put(32892, "PURUSOTTAM EXPRESS");
        TrainMap.put(12358, "NETAJI EXPRESS");
    }

    @Override
    public Ticket bookTicket(Passanger passenger) {
        Ticket t = new Ticket();
        BeanUtils.copyProperties(passenger, t);

        // set train name
        String TrainName = TrainMap.get(passenger.getTrainNumber());
        t.setTrainName(TrainName != null ? TrainName : "Unknown Train");

        // set ticket details
        t.setTicketCost(550.2);
        t.setStatus("CONFIRMED Ticket");
        t.setTrainNumber(String.valueOf(passenger.getTrainNumber()));
        t.setTicketNumber(ticketNumber);
        TicketMap.put(ticketNumber, t);
        ticketNumber++;

        if (passenger.getEmail() != null) {
            emailService.sendBookingConfirmation(passenger, t);
        }

        return t;
    }


    @Override
    public Ticket getTicket(Integer TicketNumber) {
        return TicketMap.get(TicketNumber);
    }

    @Override
    public Map<Integer, String> getAvailableTrains() {
        return TrainMap;
    }
}
