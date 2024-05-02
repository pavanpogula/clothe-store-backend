package com.clothestore.backend.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Brand {
    @Id
    private String id;
    @Field("brand")
    private String brand;

}
