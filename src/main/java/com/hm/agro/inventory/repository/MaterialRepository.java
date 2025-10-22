package com.hm.agro.inventory.repository;

import com.hm.agro.inventory.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByCategoryId(Long categoryId);
    List<Material> findByNameContainingIgnoreCase(String name);
}
