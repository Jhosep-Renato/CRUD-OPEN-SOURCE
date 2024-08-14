package com.debiansenpai.crudopensource.exception;

import jakarta.persistence.NoResultException;

public class ProductError extends NoResultException {

    private final static String MESSAGE = "PRODUCT NOT FOUND";

    public ProductError(String message) {
        super(message);
    }

    public ProductError() {
        super(MESSAGE);
    }
}
