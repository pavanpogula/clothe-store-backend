package com.clothestore.backend.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
private PaymentRequest selectedPayment;
private AddressRequest selectedAddress;
private String deliveryType;
private String customerId;
private Map<String, List<OrderItemsRequest>> selectedProductArray;
private Double total;
}
