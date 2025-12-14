package com.sweetshop.sweetshop.services;

import com.sweetshop.sweetshop.entities.Sweet;
import com.sweetshop.sweetshop.repositories.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SweetService {

    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    public Sweet addSweet(Sweet sweet) {
        return sweetRepository.save(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweetRepository.findAll();
    }

    public Optional<Sweet> getSweetById(Long id) {
        return sweetRepository.findById(id);
    }

    public Sweet updateSweet(Long id, Sweet sweetDetails) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found with id: " + id));

        sweet.setName(sweetDetails.getName());
        sweet.setCategory(sweetDetails.getCategory());
        sweet.setPrice(sweetDetails.getPrice());
        sweet.setQuantityInStock(sweetDetails.getQuantityInStock());

        return sweetRepository.save(sweet);
    }

    public void deleteSweet(Long id) {
        sweetRepository.deleteById(id);
    }

    public List<Sweet> searchSweets(String name, String category, Double minPrice, Double maxPrice) {
        if (name != null && !name.isEmpty()) return sweetRepository.findByNameContainingIgnoreCase(name);
        if (category != null && !category.isEmpty()) return sweetRepository.findByCategoryContainingIgnoreCase(category);
        if (minPrice != null && maxPrice != null) return sweetRepository.findByPriceBetween(minPrice, maxPrice);

        return sweetRepository.findAll();
    }
}
