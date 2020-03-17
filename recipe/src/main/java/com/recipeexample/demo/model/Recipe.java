package com.recipeexample.demo.model;

import java.util.Arrays;
import java.util.List;

public class Recipe {

    public String title;
    public List<Ingredient> ingredients;
    public String instruction;

    public Recipe(String title, List<Ingredient> ingredients, String instruction) {
        this.title = title;
        this.ingredients = ingredients;
        this.instruction = instruction;
    }

    public Recipe() {
    }

    @Override
    public String toString() {
        return String.format(
                "Recipe[title=%s, ingredients:'%s', instruction='%s']",
                title, Arrays.toString(ingredients.toArray()), instruction);
    }
}
