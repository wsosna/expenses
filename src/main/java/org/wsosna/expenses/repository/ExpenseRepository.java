package org.wsosna.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wsosna.expenses.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
