package com.inventoryservice;

import com.inventoryservice.model.Inventory;
import com.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory1 = Inventory.builder()
                    .name("iphone13_mini")
                    .description("iPhone 13 Mini - A compact yet powerful smartphone with a 5.4-inch display.")
                    .quantity(100)
                    .price(69999) // Price in Indian Rupees
                    .build();

            Inventory inventory2 = Inventory.builder()
                    .name("iphone13_pro_max")
                    .description("iPhone 13 Pro Max - The ultimate iPhone with a 6.7-inch display and advanced features.")
                    .quantity(15)
                    .price(129999) // Price in Indian Rupees
                    .build();

            Inventory inventory3 = Inventory.builder()
                    .name("samsung_galaxy_s21")
                    .description("Samsung Galaxy S21 - A flagship Android smartphone with a 6.2-inch display and excellent performance.")
                    .quantity(50)
                    .price(84999) // Price in Indian Rupees
                    .build();

            Inventory inventory4 = Inventory.builder()
                    .name("google_pixel_6")
                    .description("Google Pixel 6 - The latest Pixel phone with Google's own Tensor chip and an exceptional camera.")
                    .quantity(30)
                    .price(74999) // Price in Indian Rupees
                    .build();

            Inventory inventory5 = Inventory.builder()
                    .name("oneplus_9_pro")
                    .description("OnePlus 9 Pro - A premium smartphone with a 6.7-inch display and Hasselblad camera for mobile.")
                    .quantity(20)
                    .price(64999) // Price in Indian Rupees
                    .build();

            Inventory inventory6 = Inventory.builder()
                    .name("sony_xperia_5")
                    .description("Sony Xperia 5 - A sleek and powerful smartphone with a 6.1-inch display and professional-grade camera features.")
                    .quantity(10)
                    .price(59999) // Price in Indian Rupees
                    .build();

            Inventory inventory7 = Inventory.builder()
                    .name("xiaomi_mi_11")
                    .description("Xiaomi Mi 11 - A high-performance smartphone with a 6.81-inch display and impressive camera capabilities.")
                    .quantity(25)
                    .price(49999) // Price in Indian Rupees
                    .build();

            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
            inventoryRepository.save(inventory3);
            inventoryRepository.save(inventory4);
            inventoryRepository.save(inventory5);
            inventoryRepository.save(inventory6);
            inventoryRepository.save(inventory7);
        };
    }
}
