package com.sweetshop.sweetshop.repositories;

import com.sweetshop.sweetshop.entities.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SweetRepository extends JpaRepository<Sweet, Long> {

    List<Sweet> findByNameContainingIgnoreCase(String name);

    List<Sweet> findByCategoryContainingIgnoreCase(String category);

    List<Sweet> findByPriceBetween(Double minPrice, Double maxPrice);
}
