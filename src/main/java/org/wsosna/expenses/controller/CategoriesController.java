package org.wsosna.expenses.controller;

import org.springframework.web.bind.annotation.*;
import org.wsosna.expenses.entity.Category;
import org.wsosna.expenses.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoryRepository categoryRepository;

    public CategoriesController(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody final Category category) {
        category.setId(null);
        return categoryRepository.save(category);
    }

    @PostMapping("/update")
    public Category updateCategory(@RequestBody final Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@RequestParam int id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryOptional.ifPresent(categoryRepository::delete);
            return String.format("Deleted row with id %s", id);
        }
        return String.format("Row with id %s not found", id);
    }
}
