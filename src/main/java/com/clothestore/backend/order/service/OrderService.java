package com.clothestore.backend.order.service;

import com.clothestore.backend.order.dto.*;
import com.clothestore.backend.order.model.Order;
import com.clothestore.backend.order.model.Payment;
import com.clothestore.backend.order.repository.OrderRepository;
import com.clothestore.backend.order.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final PaymentRepository paymentRepository;
    private final PaymentService paymentService;
    private final OrderArrayService orderArrayService;
    private final OrderRepository orderRepository;
    @Transactional
    public  void addOrder(AddOrderRequest addOrderRequest) {
        try {
            String paymentId = paymentService.addPayment(addOrderRequest.getSelectedPayment());
            String orderId = orderArrayService.addOrderArray(addOrderRequest.getSelectedProductArray());
            AddressRequest addressRequest = addOrderRequest.getSelectedAddress();
            log.warn("addressRequest : {}",addressRequest);
            Order order = Order.builder()
                    .customerId((addOrderRequest.getCustomerId()))
                    .deliveryType(addOrderRequest.getDeliveryType())
                    .deliveryStatus("inProgress")
                    .order_array((orderId))
                    .timestamp(new Date())
                    .payment((paymentId))
                    .total(addOrderRequest.getTotal())
                    .pin(addressRequest.getPin())
                    .city(addressRequest.getCity())
                    .state(addressRequest.getState())
                    .street(addressRequest.getStreet())
                    .build();
            String result = orderRepository.save(order).getId();




            log.info("addOrder - OrderService  id : {}", result);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }
    }


    public List<OrderResponse> fetchAllOrders() {
        log.info(" fetchAllOrders ");
        List<Order> orders = orderRepository.findAll();
    return orders.stream().map(this::mapToOrderResponse).toList();
    }
 public List<CustomerOrderResponse>   getOrdersByCustomerId(String customerId) {
        log.info(" fetchAllOrders ");
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream().map(this::mapToCustomerOrderResponse).toList();
    }
    public String updateOrder(UpdateOrderRequest updateOrderRequest) {

        Optional<Order> optionalOrder = orderRepository.findById(updateOrderRequest.getOrderId());
        if(optionalOrder.isPresent()){
            log.info(" orderUpdated - {} ",optionalOrder.get().getId());
            Order order = optionalOrder.get();
            order.setDeliveryStatus("delivered");
            orderRepository.save(order);
        }
        return "success";
    }

    private CustomerOrderResponse mapToCustomerOrderResponse(Order order){
        return CustomerOrderResponse.builder()
                .id(order.getId())
                .total(order.getTotal())
                .timestamp(order.getTimestamp())
                .deliveryStatus(order.getDeliveryStatus())
                .build();
    }
    private OrderResponse mapToOrderResponse(Order order){

    AddressRequest addressRequest = AddressRequest.builder()
            .country("USA")
            .city(order.getCity())
            .street(order.getStreet())
            .pin(order.getPin())
            .build();
            return OrderResponse.builder()
                    .id(order.getId())
                    .deliveryStatus(order.getDeliveryStatus())
                    .deliveryType(order.getDeliveryType())
                    .timestamp(order.getTimestamp())
                    .payment(order.getPayment())
                    .customerId(order.getCustomerId())
                    .total(order.getTotal())
                    .addressData(addressRequest)
                    .build();
    }

    public PaymentResponse getPaymentById(String id) {
       Optional<Payment> optionalPayment =  paymentRepository.findById(id);
       if(optionalPayment.isPresent()){
           Payment payment = optionalPayment.get();
          return PaymentResponse.builder()
                   .cardNumber(payment.getCardNumber())
                   .cardType(payment.getCardType())
                   .build();
       }
       return PaymentResponse.builder().build();
    }
}
