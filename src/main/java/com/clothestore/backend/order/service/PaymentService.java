package com.clothestore.backend.order.service;

import com.clothestore.backend.order.dto.AddOrderRequest;
import com.clothestore.backend.order.dto.PaymentRequest;
import com.clothestore.backend.order.model.Payment;
import com.clothestore.backend.order.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    public  String addPayment(PaymentRequest paymentRequest) {

        Payment payment = Payment.builder()
                .cardNumber(paymentRequest.getCardNumber())
                .cardType(paymentRequest.getCardType())
                .build();

       String result =  paymentRepository.save(payment).getId();
       log.info("addPayment - PaymentService id : {} ",result);
       return result;
    }
}
