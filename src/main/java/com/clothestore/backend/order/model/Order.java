package com.clothestore.backend.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

@Document(value = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    @Id
    private String id;

    @Field("customerId")
    private String customerId;

    @Field("deliveryType")
    private String deliveryType;

    @Field("deliveryStatus")
    private String deliveryStatus;

    @Field("order_array")
    private String order_array;

    @Field("timestamp")
    private Date timestamp;

    @Field("payment")
    private String payment;

    @Field("total")
    private Double total;

    @Field("street")
    private String street;

    @Field("pin")
    private String pin;

    @Field("city")
    private String city;

    @Field("state")
    private String state;



}
