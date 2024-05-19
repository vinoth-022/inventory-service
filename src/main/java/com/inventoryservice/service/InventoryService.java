package com.inventoryservice.service;

import com.inventoryservice.dto.InventoryResponse;
import com.inventoryservice.model.Inventory;
import com.inventoryservice.repository.InventoryRepository;
//import com.productservice.dto.ProductResponse;
//import com.productservice.model.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    
    public List<Inventory> fetchAllItems() {
        List<Inventory> items = inventoryRepository.findAll() ;
        return items.stream().map(this::mapToInventoryResponse).toList();
    }
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> name) {
    	System.out.println("isInStock checker in inventory service : " + name);
         return inventoryRepository.findByNameIn(name)
                 .stream()
                 .map(inventory -> InventoryResponse.builder()
                         .name(inventory.getName())
                         .isInStock(inventory.getQuantity() > 0)
                         .build()).toList() ;
    }
    
    @Transactional
    public void decrementStock(List<String> skuCode) {
        List<Inventory> inventories = inventoryRepository.findByNameIn(skuCode);
        inventories.forEach(inventory -> {
            inventory.setQuantity(inventory.getQuantity() - 1);
            inventoryRepository.save(inventory);
        });
    }
    
    public boolean existsBySkuCode (String skuCode) {
    	 return inventoryRepository.existsByName(skuCode);
    }
    
    private Inventory mapToInventoryResponse(Inventory inventory) {
        return Inventory.builder()
                .name(inventory.getName())
                .description(inventory.getDescription())  // Assuming `description` is a field in `Inventory`
                .quantity(inventory.getQuantity())
                .price(inventory.getPrice())
                .build();
    }
//    @Transactional
//    public void decrementProductQuantities(List<String> skuCodes) {
//        List<Inventory> inventories = inventoryRepository.findBySkuCodeIn(skuCodes);
//        for (Inventory inventory : inventories) {
//            int currentQuantity = inventory.getQuantity();
//            if (currentQuantity > 0) {
//                inventory.setQuantity(currentQuantity - 1);
//                inventoryRepository.save(inventory);
//            }
//            // You might want to handle cases where the quantity is already 0
//        }
//    }
}
