package com.clothestore.backend.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProductResponse {
   private String productId;
   private String title;
   private String description;
   private String price;
   private String[] sizes;
   private String quantity;
   private String color;

}
