package com.recipeexample.demo.service;

import com.recipeexample.demo.model.Recipe;
import com.recipeexample.demo.model.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> retrieveAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipeByTitle(String title) {
        return recipeRepository.findByTitle(title);
    }

    public void deleteAll() {
        recipeRepository.deleteAll();
    }
}
