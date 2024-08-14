package com.debiansenpai.crudopensource.model.repository;

import com.debiansenpai.crudopensource.model.dto.CategoryDTO;
import com.debiansenpai.crudopensource.model.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductRepository {

    List<Product> findAllProductWithCategory();

    List<Product> findCategoryWithProducts(Set<CategoryDTO> categories);
}
