package com.clothestore.backend.product.controller;

import com.clothestore.backend.product.dto.AddProductRequest;
import com.clothestore.backend.product.dto.ProductImagesResponse;
import com.clothestore.backend.product.dto.UpdateProductResponse;
import com.clothestore.backend.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public String addProduct(@ModelAttribute AddProductRequest addProductRequest, @RequestParam("productImage") MultipartFile image){
        addProductRequest.setImage(image);
       return productService.addProduct(addProductRequest);
    }

    @GetMapping("/getAllProductsWithImages")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductImagesResponse> fetchAllProductsWithImages(){
        return productService.fetchAllProductsWithImages();
    }

    @PostMapping("/updateProductAdmin")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateProduct(@RequestBody UpdateProductResponse updateProductResponse){
        return productService.updateProduct(updateProductResponse);
    }

    @GetMapping("/getAllBrands")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<String>> fetchAllBrands(){
        return productService.fetchAllBrands();
    }









}
