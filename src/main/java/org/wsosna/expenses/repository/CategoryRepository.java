package org.wsosna.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wsosna.expenses.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
