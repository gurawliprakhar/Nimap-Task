package com.nimap.nimap_assignment.controller;

import com.nimap.nimap_assignment.model.Category;
import com.nimap.nimap_assignment.repository.CategoryRepository;
import com.nimap.nimap_assignment.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/categories")
    public Page<Category> getCategories(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }

    // POST API to create a new category
    @PostMapping("/api/categories")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
        Category createdCategory = CategoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // GET category by ID
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        // Find the category by ID using the service layer
        Category category = categoryService.getCategoryById(id);

        // Check if the category exists
        if (category == null) {
            // Return a 404 if category is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Return the found category with a 200 OK status
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // PUT - Update category by ID
    @PutMapping("/api/categories/{id}")
    public ResponseEntity<Category> updateCategoryById(
            @PathVariable("id") Long id,
            @RequestBody Category updatedCategory) {

        // Call the service to update the category
        Category updated = categoryService.updateCategoryById(id, updatedCategory);

        // If no category found, return 404
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Return updated category with 200 OK
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // DELETE - Delete category by ID
    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable("id") Long id) {
        boolean isDeleted = categoryService.deleteCategoryById(id);

        // If the category was not found, return 404
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // If successfully deleted, return 204 No Content
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
