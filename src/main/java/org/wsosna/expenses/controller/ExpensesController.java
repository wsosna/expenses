package org.wsosna.expenses.controller;

import org.springframework.web.bind.annotation.*;
import org.wsosna.expenses.dto.ExpenseRequest;
import org.wsosna.expenses.entity.Expense;
import org.wsosna.expenses.repository.ExpenseRepository;
import org.wsosna.expenses.service.ExpenseManagementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    private final ExpenseRepository expenseRepository;
    private final ExpenseManagementService expenseManagementService;

    public ExpensesController(final ExpenseRepository expenseRepository, ExpenseManagementService expenseManagementService) {
        this.expenseRepository = expenseRepository;
        this.expenseManagementService = expenseManagementService;
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @PostMapping("/add")
    public Expense addExpense(@RequestBody final ExpenseRequest expenseRequest) {
        Expense expense = new Expense(
                expenseRequest.getName(),
                expenseRequest.getDescription(),
                expenseRequest.getPrice(),
                expenseManagementService.mapToCategories(expenseRequest.getCategoryIds())
        );
        return expenseRepository.save(expense);
    }

    @PostMapping("/update")
    public Expense updateExpense(@RequestBody final ExpenseRequest expenseRequest) {
        Expense expense = new Expense(
                expenseRequest.getId(),
                expenseRequest.getName(),
                expenseRequest.getDescription(),
                expenseRequest.getPrice(),
                expenseManagementService.mapToCategories(expenseRequest.getCategoryIds())
        );
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
