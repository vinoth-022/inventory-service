package com.inventoryservice.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import com.inventoryservice.model.Inventory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, ObjectId> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
