package lk.ijse.payment_service.controller;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/paymentService")
public class PaymentController {

    @Autowired
    PaymentServices paymentServices;

    @GetMapping
    public void checkHealth(){
        System.out.println("Payment worked...");
    }

    @PostMapping("/confirmPayment")
    public String confirmPayment(@RequestBody PaymentDTO paymentDTO){
        String confirmPaymentMessage = paymentServices.confirmPayment(paymentDTO);
        return confirmPaymentMessage;
    }
}
