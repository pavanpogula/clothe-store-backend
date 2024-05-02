package com.clothestore.backend.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    private String title;
    private MultipartFile image;
    private String description;
    private String price;
    private String brand;
    private String sizes[];
    private String color;
    private String company;
    private String quantity;

}
