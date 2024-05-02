package com.clothestore.backend.product.service;

import com.clothestore.backend.product.model.Image;
import com.clothestore.backend.product.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public String addImage(String title, MultipartFile file)  {
        String result = null;
        try {
           Image image =  Image.builder()
                   .img(new Binary(BsonBinarySubType.BINARY, file.getBytes()))
                   .title(file.getOriginalFilename())
                   .fileContentType(file.getContentType())
                   .build();
         result =  imageRepository.save(image).getId();
        log.info("Image added successfully : {} ",result);
        } catch (IOException e) {
          log.error("Error in Image Upload : {}",e.getLocalizedMessage());
        }
        return result;
    }

}
