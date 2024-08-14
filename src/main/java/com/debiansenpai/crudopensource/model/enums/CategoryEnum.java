package com.debiansenpai.crudopensource.model.enums;

public enum CategoryEnum {

    ROM("Romantic"),
    CIF("Science Fiction"),
    FAN("Fantasy"),
    AVE("Aventures");

    private final String category;

    CategoryEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }


}
