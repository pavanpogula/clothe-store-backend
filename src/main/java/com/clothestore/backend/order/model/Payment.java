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

@Document(value = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Payment {
    @Id
    private String id;

    @Field("cardType")
    private String cardType;

    @Field("cardNumber")
    private String cardNumber;



}
