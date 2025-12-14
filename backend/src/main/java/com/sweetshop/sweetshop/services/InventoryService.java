package com.sweetshop.sweetshop.services;

import com.sweetshop.sweetshop.entities.Sweet;
import com.sweetshop.sweetshop.repositories.SweetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final SweetRepository sweetRepository;

    public InventoryService(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    @Transactional
    public Sweet purchaseSweet(Long sweetId, int quantity) {
        Sweet sweet = sweetRepository.findById(sweetId)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        if (sweet.getQuantityInStock() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        sweet.setQuantityInStock(sweet.getQuantityInStock() - quantity);
        return sweetRepository.save(sweet);
    }

    @Transactional
    public Sweet restockSweet(Long sweetId, int quantity) {
        Sweet sweet = sweetRepository.findById(sweetId)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        sweet.setQuantityInStock(sweet.getQuantityInStock() + quantity);
        return sweetRepository.save(sweet);
    }
}
