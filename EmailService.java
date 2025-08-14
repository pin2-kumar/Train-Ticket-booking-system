package com.TrainTicketBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.TrainTicketBooking.passeger.Passanger;
import com.TrainTicketBooking.ticket.Ticket;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendBookingConfirmation(Passanger passenger, Ticket ticket) {
        if (passenger == null) {
            System.out.println("ERROR: Passenger is null. Cannot send email.");
            return;
        }

        String email = passenger.getEmail();
        String subject = "Train Ticket Booking Confirmation";

        String message = "Dear " + passenger.getName() + ",\n\n" +
                "Your ticket has been successfully booked!\n" +
                "Train: " + ticket.getTrainName() + "\n" +
                "From: " + ticket.getFrom() + "\n" +
                "To: " + ticket.getTo() + "\n" +
                "Date: " + ticket.getDate() + "\n" +
                "Seat No: " + ticket.getTicketNumber() + "\n\n" +
                "Thank you for booking with us!\n" +
                "Happy Journey!";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
        System.out.println("Email sent to: " + email);
    }
}
