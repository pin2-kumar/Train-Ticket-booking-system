package com.TrainTicketBooking.service;

import com.TrainTicketBooking.ticket.Ticket;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfGeneratorService {

    public ByteArrayInputStream generatePdf(Ticket ticket) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Fonts
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLUE);
            Font subHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            // Header
            Paragraph header = new Paragraph("Train Ticket Confirmation", headerFont);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);

            document.add(Chunk.NEWLINE);

            // Passenger Info
            Paragraph passengerHeader = new Paragraph("Passenger Details", subHeaderFont);
            document.add(passengerHeader);
            document.add(new Paragraph("Name           : " + ticket.getName(), normalFont));
            document.add(new Paragraph("Email          : " + ticket.getEmail(), normalFont));
            document.add(new Paragraph("Ticket Number  : " + ticket.getTicketNumber(), normalFont));

            document.add(Chunk.NEWLINE);

            // Train Info
            Paragraph trainHeader = new Paragraph("Train Details", subHeaderFont);
            document.add(trainHeader);
            document.add(new Paragraph("Train Name     : " + ticket.getTrainName(), normalFont));
            document.add(new Paragraph("Train Number   : " + ticket.getTrainNumber(), normalFont));
            document.add(new Paragraph("From           : " + ticket.getFrom(), normalFont));
            document.add(new Paragraph("To             : " + ticket.getTo(), normalFont));
            document.add(new Paragraph("Travel Date    : " + ticket.getDate(), normalFont));

            document.add(Chunk.NEWLINE);

            // Booking Info
            Paragraph bookingHeader = new Paragraph("Booking Information", subHeaderFont);
            document.add(bookingHeader);
            document.add(new Paragraph("Status         : " + ticket.getStatus(), normalFont));
            document.add(new Paragraph("Amount Paid    : ₹" + ticket.getTicketCost(), normalFont));

            document.add(Chunk.NEWLINE);

            // Footer
            Paragraph footer = new Paragraph("Thank you for booking with TrainTicketBooking System!", normalFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
