package org.wsosna.expenses.service;

import org.springframework.stereotype.Service;
import org.wsosna.expenses.entity.Category;
import org.wsosna.expenses.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseManagementService {

    private final CategoryRepository categoryRepository;

    public ExpenseManagementService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Maps list of ids to objects. If category not found It will be ignored.
     * @param ids list of integers
     * @return list of categories
     */
    public List<Category> mapToCategories(final List<Integer> ids) {
        final List<Category> categories = new ArrayList<>();
        for (Integer id : ids) {
            categoryRepository.findById(id).ifPresent(categories::add);
        }
        return categories;
    }
}
