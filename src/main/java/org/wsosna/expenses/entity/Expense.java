package org.wsosna.expenses.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "expenses_categories",
            joinColumns = @JoinColumn(name = "id_expense"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))
    private List<Category> categories;

    public Expense(Integer id, String name, String description, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categories = categories;
    }

    public Expense(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categories = new ArrayList<>();
    }

    public Expense() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
