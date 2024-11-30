package com.nimap.nimap_assignment.repository;

import com.nimap.nimap_assignment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
