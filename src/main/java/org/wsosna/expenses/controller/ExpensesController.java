package org.wsosna.expenses.controller;

import org.springframework.web.bind.annotation.*;
import org.wsosna.expenses.entity.Expense;
import org.wsosna.expenses.repository.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    private final ExpenseRepository expenseRepository;

    public ExpensesController(final ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @PostMapping("/add")
    public Expense addExpense(@RequestBody final Expense expense) {
        expense.setId(null);
        return expenseRepository.save(expense);
    }

    @PostMapping("/update")
    public Expense updateExpense(@RequestBody final Expense expense) {
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteExpense(@RequestParam int id) {
        Optional<Expense> expenseOptional = expenseRepository.findById(id);
        if (expenseOptional.isPresent()) {
            expenseOptional.ifPresent(expenseRepository::delete);
            return String.format("Deleted row with id %s", id);
        }
        return String.format("Row with id %s not found", id);
    }
}
