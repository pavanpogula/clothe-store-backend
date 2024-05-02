package com.clothestore.backend.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImagesResponse {

    private String _id;

    private String title;

    private String description;

    private String price;

    private String brand;

    private String img;

    private Map<String, Integer> sizes;

    private Date timestamp;

    private String color;

    private String image;

    private int sales;
}
