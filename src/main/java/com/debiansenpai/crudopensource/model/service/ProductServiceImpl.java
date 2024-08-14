package com.debiansenpai.crudopensource.model.service;

import com.debiansenpai.crudopensource.exception.CategoryError;
import com.debiansenpai.crudopensource.exception.ProductError;
import com.debiansenpai.crudopensource.model.dto.CategoryDTO;
import com.debiansenpai.crudopensource.model.dto.ProductDTO;
import com.debiansenpai.crudopensource.model.entity.Product;
import com.debiansenpai.crudopensource.model.repository.ProductRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.debiansenpai.crudopensource.model.enums.CategoryEnum.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAllProductWithCategory() {

        List<Product> productList = productRepository.findAllProductWithCategory();

        return  productList.stream()
                .map(this::createProductDTO)
                .toList();
    }

    @Override
    public List<ProductDTO> findAllProductByCategories(HashSet<CategoryDTO> categories) {

        int categoriesSize = categories.size();

        if (categoriesSize == 0) {
            throw new CategoryError();
        }

        try {
            List<Product> productList = productRepository.findCategoryWithProducts(categories);

            return productList.stream()
                    .map(this::createProductDTO)
                    .toList();
        } catch (NoResultException ex) {
            throw new ProductError("Error, there are no books in this category");
        }
    }

    @Override
    public ProductDTO findProductByName(String product) {

        if (product.isEmpty()) return null;

        try {
            String newName = product;
            if (product.contains("-")) {
                newName = product.replace("-", " ");
            }
            return createProductDTO(productRepository.findProductByName(newName));
        } catch (NoResultException ex) {
            throw new ProductError("Product not found");
        }
    }

    private ProductDTO createProductDTO(Product product) {

        ProductDTO productDTO = searchCategory(product.getCategory().getNameCategory());
        productDTO.setName(product.getNameProduct());
        productDTO.setQuantity(product.getQuantityProduct());
        productDTO.setPrice(product.getPriceProduct());

        return productDTO;
    }

    private ProductDTO searchCategory(String nameCategory) {

        Map<String, String> categoryMap = Map.of(
                "ROM", ROM.getCategory(),
                "CIF", CIF.getCategory(),
                "FAN", FAN.getCategory(),
                "AVE", AVE.getCategory()
        );
        String category = categoryMap.get(nameCategory);
        return new ProductDTO(category);
    }
}
