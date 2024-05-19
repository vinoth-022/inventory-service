package com.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {
    private String name ;
    private Boolean isInStock ;
    private String description;
    private Integer quantity ; 
    private Integer price;
}
