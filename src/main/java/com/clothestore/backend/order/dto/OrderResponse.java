package com.clothestore.backend.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
private String id;
private PaymentRequest selectedPayment;
private AddressRequest addressData;
private String deliveryType;
private String deliveryStatus;
private String customerId;
private Date timestamp;
private String payment;
private Double total;
}
