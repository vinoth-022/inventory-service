package com.inventoryservice.controller;

import com.inventoryservice.dto.InventoryResponse;
import com.inventoryservice.model.Inventory;
import com.inventoryservice.service.InventoryService;
//import com.productservice.dto.ProductResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService ;


//    eg: http://localhost:8082/api/inventory?skuCode=iphone_13&skuCode=iphone_14
    
    @GetMapping("/allItems")
    public List<Inventory> fetchAllItems() {
        return inventoryService.fetchAllItems() ;
    }
    
    @GetMapping("/check-inventory")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> name) {
    	List<InventoryResponse> temp = inventoryService.isInStock(name);
    	System.out.println("isInStock checker in inventory control" + temp);
        return temp ;
    }
    
    @PostMapping("/decrement-stock")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void decrementStock(@RequestBody List<String> name) {
      inventoryService.decrementStock(name);
    }
    
    @GetMapping("/find-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public boolean existsBySkuCode(@PathVariable String name) {
        return inventoryService.existsBySkuCode(name);
    }
    

}
