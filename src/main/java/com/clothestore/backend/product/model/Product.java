package com.clothestore.backend.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

@Document(value = "clothes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field("price")
    private String price;

    @Field("brand")
    private String brand;

    @Field("sizes")
    private Map<String, Integer> sizes;

    @Field("img")
    private ObjectId img;

    @Field("timestamp")
    private Date timestamp;

    @Field("color")
    private String color;

    @Field("sales")
    private int sales;
}
