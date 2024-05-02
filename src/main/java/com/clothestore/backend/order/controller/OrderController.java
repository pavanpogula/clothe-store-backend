package com.clothestore.backend.order.controller;

import com.clothestore.backend.order.dto.*;

import com.clothestore.backend.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String addOrder(@RequestBody AddOrderRequest addOrderRequest){
        log.warn(" orderDetails : {}",addOrderRequest);
        orderService.addOrder(addOrderRequest);
       return  "success";
    }

    @GetMapping("/getAllOrders")
    @ResponseStatus(HttpStatus.CREATED)
    public List<OrderResponse> fetchAllOrders(){
        return orderService.fetchAllOrders();
    }


    @GetMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse getPayment(@RequestParam String id){
        log.info(" getPayment :  "+id);
        return orderService.getPaymentById(id);
    }


    @PostMapping("/updateOrder")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateOrder(@RequestBody UpdateOrderRequest updateOrderRequest){
        log.warn(" updateOrderRequest : {}",updateOrderRequest);
        return  orderService.updateOrder(updateOrderRequest);

    }

    @PostMapping("/getOrdersByCustomerId")
    @ResponseStatus(HttpStatus.CREATED)
    public List<CustomerOrderResponse>  getOrdersByCustomerId(@RequestBody CustomerOrderRequest customerOrderRequest){
        log.info(" getPayment :  "+customerOrderRequest.getCustomerId());
        return orderService.getOrdersByCustomerId(customerOrderRequest.getCustomerId());
    }




}
