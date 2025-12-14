package com.sweetshop.sweetshop.controllers;

import com.sweetshop.sweetshop.entities.Sweet;
import com.sweetshop.sweetshop.services.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sweets")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/{id}/purchase")
    public ResponseEntity<Sweet> purchaseSweet(@PathVariable Long id, @RequestParam int quantity) {
        Sweet updatedSweet = inventoryService.purchaseSweet(id, quantity);
        return ResponseEntity.ok(updatedSweet);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/restock")
    public ResponseEntity<Sweet> restockSweet(@PathVariable Long id, @RequestParam int quantity) {
        Sweet updatedSweet = inventoryService.restockSweet(id, quantity);
        return ResponseEntity.ok(updatedSweet);
    }
}
