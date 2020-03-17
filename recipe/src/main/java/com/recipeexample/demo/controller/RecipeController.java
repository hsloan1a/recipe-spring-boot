package com.recipeexample.demo.controller;

import com.recipeexample.demo.model.Recipe;
import com.recipeexample.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/all_recipe")
    public List<Recipe> listAll() {
        return recipeService.retrieveAllRecipes();
    }

    @PostMapping("/add")
    public Recipe add(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @PostMapping("/delete")
    public void deleteAll() {
        recipeService.deleteAll();

    }

}
