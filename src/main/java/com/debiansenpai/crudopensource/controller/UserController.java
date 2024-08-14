package com.debiansenpai.crudopensource.controller;

import com.debiansenpai.crudopensource.model.dto.CategoryDTO;
import com.debiansenpai.crudopensource.model.dto.ProductDTO;
import com.debiansenpai.crudopensource.model.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private ProductService productService;

    public UserController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findProducts")
    public ResponseEntity<List<ProductDTO>> findProducts() {
        return new ResponseEntity<>(productService.findAllProductWithCategory(), HttpStatus.OK);
    }

    @GetMapping("/findProductsByCategories/{categories}")
    public ResponseEntity<List<ProductDTO>> findProductsByCategories(
            @PathVariable("categories") HashSet<CategoryDTO> categories
    ) {
        return new ResponseEntity<>(productService
                .findAllProductByCategories(categories), HttpStatus.OK);
    }
}
