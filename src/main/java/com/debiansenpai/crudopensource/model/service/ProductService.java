package com.debiansenpai.crudopensource.model.service;

import com.debiansenpai.crudopensource.model.dto.CategoryDTO;
import com.debiansenpai.crudopensource.model.dto.ProductDTO;

import java.util.HashSet;
import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProductWithCategory();

    List<ProductDTO> findAllProductByCategories(HashSet<CategoryDTO> categories);

}
