package com.clothestore.backend.order.service;

import com.clothestore.backend.order.dto.OrderItemsRequest;
import com.clothestore.backend.order.model.OrderArray;
import com.clothestore.backend.order.model.OrderItems;
import com.clothestore.backend.order.repository.OrderArrayRepository;
import com.clothestore.backend.product.model.Product;
import com.clothestore.backend.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderArrayService {
    private final OrderArrayRepository orderArrayRepository;
    private final ProductRepository productRepository;

    public String addOrderArray(Map<String, List<OrderItemsRequest>> OrderItemsRequestList){
        Map<String, List<OrderItems>> obj = new HashMap<>();
        for(String key : OrderItemsRequestList.keySet()){
            List<OrderItems> orderList =   OrderItemsRequestList.get(key).stream().map(this::mapDto).filter(order -> order.getSelected()!=null).toList();
            obj.put(key,orderList);

            Optional<Product> optionalProduct = productRepository.findById(key);
            if(optionalProduct.isPresent()){
                Product product = optionalProduct.get();
                Map<String,Integer> mapper = product.getSizes();
                int count =product.getSales();
                for(OrderItems x : orderList){
                   int presentSizes =  mapper.get(x.getSize());
                   count=count + x.getSelected();
                   presentSizes = presentSizes - x.getSelected();
                   mapper.put(x.getSize(),presentSizes);
                }
                product.setSizes(mapper);
                product.setSales(count);
                log.error(" addOrderArray :   {} ",product);
                productRepository.save(product);
            }

        }





        OrderArray orderArray = OrderArray.builder()
                .ordersList(obj)
                .build();
        String result = orderArrayRepository.save(orderArray).getId();
        log.info("addOrderArray -  OrderArrayService id : {}",result);
        return result;
    }

    private OrderItems mapDto(OrderItemsRequest orderItemsRequest) {
        if(orderItemsRequest.getSelected() ==0 ){
            return OrderItems.builder().build();
        }else{
            return OrderItems.builder()
                    .quantity(orderItemsRequest.getQuantity())
                    .selected(orderItemsRequest.getSelected())
                    .size(orderItemsRequest.getSize())
                    .build();
        }


    }
}
