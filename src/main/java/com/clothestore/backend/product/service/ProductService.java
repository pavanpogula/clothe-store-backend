package com.clothestore.backend.product.service;

import com.clothestore.backend.product.dto.AddProductRequest;
import com.clothestore.backend.product.dto.ProductImagesResponse;
import com.clothestore.backend.product.dto.UpdateProductResponse;
import com.clothestore.backend.product.model.Brand;
import com.clothestore.backend.product.model.Image;
import com.clothestore.backend.product.model.Product;
import com.clothestore.backend.product.repository.BrandRepository;
import com.clothestore.backend.product.repository.ImageRepository;
import com.clothestore.backend.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ImageService imageService;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;
    private final BrandRepository brandRepository;
    public String addProduct(AddProductRequest addProductRequest){

            String company = addProductRequest.getBrand().equals("new")? addProductRequest.getCompany():addProductRequest.getBrand();
            if(addProductRequest.getBrand().equals("new")){
                Brand brand = Brand.builder()
                        .brand(company)
                        .build();
                brandRepository.save(brand);
            }
       String imageId = imageService.addImage(addProductRequest.getTitle(),addProductRequest.getImage());

       if(imageId!=null){

           Product product = Product.builder()
                   .img(new ObjectId(imageId))
                   .brand(company)
                   .sizes(convertUpdateResponse(addProductRequest.getSizes(),addProductRequest.getQuantity()))
                   .description(addProductRequest.getDescription())
                   .title(addProductRequest.getTitle())
                   .price(addProductRequest.getPrice())
                   .timestamp(new Date())
                   .color(addProductRequest.getColor())
                   .sales(0)
                   .build();
           String id = productRepository.save(product).getId();
           log.info("addProduct ProductService : {} ",id);
           return "success";
       }
       return "error";
    }


    public List<ProductImagesResponse> fetchAllProductsWithImages(){
           List<Product> products = productRepository.findAll();
        return  products.stream().map(this::mapToProductResponse).filter(obj->obj.get_id()!=null).toList();
    }






    private ProductImagesResponse mapToProductResponse(Product product){

       Optional<Image> imageOptional=  imageRepository.findById(product.getImg().toString());
        if(imageOptional.isPresent()){
            String base64EncodedString = Base64.getEncoder().encodeToString(imageOptional.get().getImg().getData());
            String dataUri = "data:image/png;base64," + base64EncodedString;
            return ProductImagesResponse.builder()
                    ._id(product.getId())
                    .brand(product.getBrand())
                    .color(product.getColor())
                    .img(product.getImg().toString())
                    .image(dataUri)
                    .description(product.getDescription())
                    .sizes(product.getSizes())
                    .timestamp(product.getTimestamp())
                    .title(product.getTitle())
                    .price(product.getPrice())
                    .sales(product.getSales())
                    .build();
        }
        return ProductImagesResponse.builder().build();

    }

    public String updateProduct(UpdateProductResponse updateProductResponse) {
        Optional<Product> optionalProduct = productRepository.findById(updateProductResponse.getProductId());
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();

            product.setTitle(updateProductResponse.getTitle());
            product.setDescription(updateProductResponse.getDescription());
            product.setPrice(updateProductResponse.getPrice());

            Map<String, Integer> updatedHashMap = new HashMap<>(product.getSizes());
            Map<String,Integer> convertedMap = convertUpdateResponse(updateProductResponse.getSizes(),updateProductResponse.getQuantity());

            convertedMap.forEach((key, value) ->
                    updatedHashMap.merge(key, value, Integer::sum));


            product.setSizes(updatedHashMap);
            product.setColor(updateProductResponse.getColor());

            productRepository.save(product);
            log.info("updateProduct ProductService id : {} ",product.getId());

        }else{
            log.error("updateProduct ProductService ");
            return "error";
        }
        return "success";

    }

    public Map<String, List<String>> fetchAllBrands() {
    Map<String,List<String>> result = new HashMap<>();
    result.put("brands",new ArrayList<>());
        List<Brand> brands = brandRepository.findAll();
        for(Brand data : brands){
            result.get("brands").add(data.getBrand());
        }
    return result;
    }




    private Map<String, Integer> convertUpdateResponse(String[] arr, String quantity){
        Map<String, Integer> hashMap = new HashMap<>();
        for(String x:arr){
            hashMap.put(x,Integer.parseInt(quantity));
        }
        return hashMap;
    }
    private Map<String,Integer> convertToMap(String data){
        String pairs[] = data.split(",");
        Map<String, Integer> hashMap = new HashMap<>();
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0];
            Integer value = Integer.parseInt(keyValue[1]);
            hashMap.put(key, value);
        }
        return hashMap;
    }



}
