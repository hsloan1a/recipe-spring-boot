package com.recipeexample.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.recipeexample.demo.serializer.AmountCatagorySerializer;

public class Ingredient {

    public Ingredient() {
    }

    public Ingredient(String unit, AmountCatagory amount, String ingredient) {
        this.amount = amount;
        this.unit = unit;
        this.ingredient = ingredient;
    }

    @JsonSerialize(using = AmountCatagorySerializer.AmountCatagoryJsonSerializer.class)
    @JsonDeserialize(using = AmountCatagorySerializer.AmountCatagoryJsonDeserializer.class)
    public AmountCatagory amount;
    public String unit;
    public String ingredient;

    public AmountCatagory getAmount() {
        return amount;
    }

    public void setAmount(AmountCatagory amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return String.format(
                "[Ingredient:%s, '%s', '%s']",
                unit, amount.getValue(), ingredient);
    }
}
