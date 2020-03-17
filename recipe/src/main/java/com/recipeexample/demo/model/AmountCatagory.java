package com.recipeexample.demo.model;

import java.util.Arrays;

public enum AmountCatagory {

    cup("cup"), tablespoon("tbl"), teaspoon("tsp");

    private String value;

    AmountCatagory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmountCatagory fromValue(String value) {
        for (AmountCatagory category : values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
