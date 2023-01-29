package org.wsosna.expenses.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.wsosna.expenses.entity.Category;
import org.wsosna.expenses.repository.CategoryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseManagementServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ExpenseManagementService expenseManagementService;

    @Test
    public void contextLoads() {
        assertThat(categoryRepository).isNotNull();
        assertThat(expenseManagementService).isNotNull();
    }

    @Test
    public void shouldReturnAllCategories() {
        final List<Category> expected = Arrays.asList(
                new Category(1, "food", "#0DC9D6"),
                new Category(2, "pets", "#0DC9D6"),
                new Category(3, "fun", "#0DC9D6")
        );

        when(categoryRepository.findById(1))
                .thenReturn(Optional.of(expected.get(0)));
        when(categoryRepository.findById(2))
                .thenReturn(Optional.of(expected.get(1)));
        when(categoryRepository.findById(3))
                .thenReturn(Optional.of(expected.get(2)));

        final List<Category> categories = expenseManagementService.mapToCategories(Arrays.asList(1, 2, 3));
        assertEquals(expected, categories);
    }

    @Test
    public void shouldReturnAllFoundCategories() {
        final List<Category> expected = Arrays.asList(
                new Category(1, "food", "#0DC9D6"),
                new Category(2, "pets", "#0DC9D6")
        );

        when(categoryRepository.findById(1))
                .thenReturn(Optional.of(expected.get(0)));
        when(categoryRepository.findById(2))
                .thenReturn(Optional.of(expected.get(1)));
        when(categoryRepository.findById(3))
                .thenReturn(Optional.empty());

        final List<Category> categories = expenseManagementService.mapToCategories(Arrays.asList(1, 2, 3));
        assertEquals(expected, categories);
    }

    @Test
    public void shouldReturnEmptyListWhenNoCategoriesFound() {
        when(categoryRepository.findById(1))
                .thenReturn(Optional.empty());
        when(categoryRepository.findById(2))
                .thenReturn(Optional.empty());
        when(categoryRepository.findById(3))
                .thenReturn(Optional.empty());

        final List<Category> categories = expenseManagementService.mapToCategories(Arrays.asList(1, 2, 3));
        assertEquals(0, categories.size());
    }
}
