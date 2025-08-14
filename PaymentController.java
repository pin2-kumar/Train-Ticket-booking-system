package com.TrainTicketBooking.controller;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.Value;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private String razorpayKey;

    private String razorpaySecret;

    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {

        RazorpayClient razorpay = new RazorpayClient(razorpayKey, razorpaySecret);

        JSONObject options = new JSONObject();
        options.put("amount", data.get("amount")); // amount in paise (e.g. 50000 = ₹500)
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");

        Order order = (Order) razorpay.items.create(options);
        return ResponseEntity.ok(order.toString());
    }
}
