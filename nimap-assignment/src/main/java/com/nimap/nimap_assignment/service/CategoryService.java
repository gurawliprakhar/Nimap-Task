package com.nimap.nimap_assignment.service;

import com.nimap.nimap_assignment.model.Category;
import com.nimap.nimap_assignment.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private static CategoryRepository categoryRepository;

    public Page<Category> getCategories(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }

    // Method to save a new category
    public static Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Method to get category by ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);  // Returns null if not found
    }

    // Method to update category by ID
    public Category updateCategoryById(Long id, Category updatedCategory) {
        return categoryRepository.findById(id).map(existingCategory -> {
            // Update fields
            existingCategory.setName(updatedCategory.getName());
            // Save updated category
            return categoryRepository.save(existingCategory);
        }).orElse(null); // Return null if category not found
    }

    // Method to delete category by ID
    public boolean deleteCategoryById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id); // Delete the category
            return true; // Return true if deleted successfully
        }
        return false; // Return false if category not found
    }
}
