package com.inventoryservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
//import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "inventory")
public class Inventory {

  
    private ObjectId id ; // abc - iPhone14 
    private String name ; // def
    private String description;
    private Integer quantity ; // 10 
    private Integer price;
    // productId == Product id 
}
