package com.clothestore.backend.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderItems {
    private String size;
    private Integer quantity;
    private Integer selected;
}
