package com.hm.agro.inventory.service;

import com.hm.agro.inventory.model.*;
import com.hm.agro.inventory.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final CategoryRepository categoryRepo;
    private final MaterialRepository materialRepo;

    public InventoryService(CategoryRepository categoryRepo, MaterialRepository materialRepo) {
        this.categoryRepo = categoryRepo;
        this.materialRepo = materialRepo;
    }

    public List<Category> listCategories() { return categoryRepo.findAll(); }
    public Category saveCategory(Category c) { return categoryRepo.save(c); }
    public Optional<Category> getCategory(Long id) { return categoryRepo.findById(id); }
    public void deleteCategory(Long id) { categoryRepo.deleteById(id); }

    public List<Material> listMaterials() { return materialRepo.findAll(); }
    public List<Material> listByCategory(Long categoryId) { return materialRepo.findByCategoryId(categoryId); }
    public Material saveMaterial(Material m) { return materialRepo.save(m); }
    public Optional<Material> getMaterial(Long id) { return materialRepo.findById(id); }
    public void deleteMaterial(Long id) { materialRepo.deleteById(id); }
}
