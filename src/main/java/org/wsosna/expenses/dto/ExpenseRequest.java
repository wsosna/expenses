package org.wsosna.expenses.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExpenseRequest {

    private Integer id;
    private String name;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    private List<Integer> categoryIds;

    public ExpenseRequest(@Nullable Integer id, String name, String description, BigDecimal price, @Nullable List<Integer> categoryIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryIds = categoryIds == null ? new ArrayList<>() : categoryIds;
    }

    public ExpenseRequest() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
