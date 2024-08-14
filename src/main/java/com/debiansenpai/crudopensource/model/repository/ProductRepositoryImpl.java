package com.debiansenpai.crudopensource.model.repository;

import com.debiansenpai.crudopensource.model.dto.CategoryDTO;
import com.debiansenpai.crudopensource.model.entity.Category;
import com.debiansenpai.crudopensource.model.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager entityManager;

    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAllProductWithCategory() {

        final String HQL = "SELECT p FROM Product p JOIN FETCH p.category";

        TypedQuery<Product> typedQuery = entityManager.createQuery(HQL, Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Product> findCategoryWithProducts(Set<CategoryDTO> categories) throws NoResultException{

        final String HQL = "SELECT c FROM Category c JOIN FETCH c.products WHERE nameCategory =:category";

        return categories.stream()
                .map(category -> {
                    TypedQuery<Category> typedQuery = entityManager.createQuery(
                            HQL, Category.class);
                    typedQuery.setParameter("category", category.getCategory());

                    return typedQuery.getSingleResult().getProducts();
                })
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    public Product findProductByName(String product) throws NoResultException {

        final String HQL = "SELECT p FROM Product p JOIN FETCH p.category WHERE nameProduct =:name";

        TypedQuery<Product> typedQuery = entityManager.createQuery(HQL, Product.class);
        typedQuery.setParameter("name", product);

        return typedQuery.getSingleResult();
    }
}
