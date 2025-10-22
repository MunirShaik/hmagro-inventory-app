package com.hm.agro.inventory.controller;

import com.hm.agro.inventory.model.*;
import com.hm.agro.inventory.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", service.listCategories());
        model.addAttribute("categoryForm", new Category());
        return "categories";
    }

    @PostMapping("/categories")
    public String saveCategory(@Valid @ModelAttribute("categoryForm") Category category, BindingResult br) {
        if (br.hasErrors()) return "categories";
        service.saveCategory(category);
        return "redirect:/inventory/categories";
    }

    @GetMapping("/categories/{id}")
    public String viewCategory(@PathVariable Long id, Model model) {
        var catOpt = service.getCategory(id);
        if (catOpt.isEmpty()) return "redirect:/inventory/categories";
        var cat = catOpt.get();
        model.addAttribute("category", cat);
        model.addAttribute("materials", service.listByCategory(id));
        model.addAttribute("materialForm", new Material());
        return "category-detail";
    }

    @PostMapping("/categories/{id}/materials")
    public String addMaterial(@PathVariable Long id, @ModelAttribute("materialForm") Material material) {
        service.getCategory(id).ifPresent(cat -> {
            material.setCategory(cat);
            if (material.getQuantity() == null) material.setQuantity(java.math.BigDecimal.ZERO);
            service.saveMaterial(material);
        });
        return "redirect:/inventory/categories/" + id;
    }

    @GetMapping("/materials/{id}/edit")
    public String editMaterial(@PathVariable Long id, Model model) {
        var mat = service.getMaterial(id);
        if (mat.isEmpty()) return "redirect:/inventory/categories";
        model.addAttribute("material", mat.get());
        model.addAttribute("categories", service.listCategories());
        return "material-edit";
    }

    @PostMapping("/materials/{id}/update")
    public String updateMaterial(@PathVariable Long id, @ModelAttribute("material") Material material) {
        service.getMaterial(id).ifPresent(existing -> {
            existing.setName(material.getName());
            existing.setSku(material.getSku());
            existing.setUnit(material.getUnit());
            existing.setQuantity(material.getQuantity());
            existing.setMinQuantity(material.getMinQuantity());
            existing.setLocation(material.getLocation());
            existing.setNotes(material.getNotes());
            if (material.getCategory() != null && material.getCategory().getId() != null) {
                service.getCategory(material.getCategory().getId()).ifPresent(existing::setCategory);
            }
            service.saveMaterial(existing);
        });
        return "redirect:/inventory/categories";
    }

    @PostMapping("/materials/{id}/delete")
    public String deleteMaterial(@PathVariable Long id) {
        service.deleteMaterial(id);
        return "redirect:/inventory/categories";
    }
}
