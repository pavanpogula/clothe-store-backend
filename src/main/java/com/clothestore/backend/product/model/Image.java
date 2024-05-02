package com.clothestore.backend.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "images")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Image {
    @Id
    private String id;
    @Field("title")
    private String title;
    @Field("img")
    private Binary img;
    @Field("fileContentType")
    private String fileContentType;
}
