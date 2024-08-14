package com.debiansenpai.crudopensource.model.dto;

public class CategoryDTO {

    private String category;

    public CategoryDTO(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return category;
    }
}
