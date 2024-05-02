package com.clothestore.backend.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Document("order_array")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderArray {
    @Id
    private String id;

    @Field("orderList")
    private Map<String, List<OrderItems>> ordersList;

}
