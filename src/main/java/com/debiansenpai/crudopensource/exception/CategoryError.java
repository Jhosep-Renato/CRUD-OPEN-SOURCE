package com.debiansenpai.crudopensource.exception;

public class CategoryError extends NullPointerException {

    private final static String MESSAGE_ERROR = "THAT CATEGORY DOES NOT EXISTS";

    public CategoryError() {
        super(MESSAGE_ERROR);
    }
}
