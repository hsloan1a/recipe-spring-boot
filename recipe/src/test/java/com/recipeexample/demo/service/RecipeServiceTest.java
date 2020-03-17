package com.recipeexample.demo.service;

import com.recipeexample.demo.model.AmountCatagory;
import com.recipeexample.demo.model.Ingredient;
import com.recipeexample.demo.model.Recipe;
import com.recipeexample.demo.model.RecipeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


public class RecipeServiceTest {

    @InjectMocks
    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRecipeBtTitleTest() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("2", AmountCatagory.cup, "sugar"));
        Recipe RecipeToTest = new Recipe("No Bake Cookies", ingredients, "Mix and put on wax paper.");
        Mockito.when(recipeRepository.findByTitle("No Bake Cookies")).thenReturn(RecipeToTest);

        Recipe foundRecipe = recipeService.getRecipeByTitle("No Bake Cookies");
        Assert.assertEquals(RecipeToTest, foundRecipe);
    }

    @Test
    public void ListAllRecipeTest() {
        List<Recipe> list = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("2", AmountCatagory.cup, "sugar"));
        Recipe RecipeToTest = new Recipe("No Bake Cookies", ingredients, "Mix and put on wax paper.");
        Recipe RecipeToTest2 = new Recipe("No Bake Cookies 2", ingredients, "Mix and put on wax paper.");
        ingredients.add(new Ingredient("1/4", AmountCatagory.teaspoon, "cocoa"));
        Recipe RecipeToTest3 = new Recipe("No Bake Cookies 2", ingredients, "Same as above.");
        list.add(RecipeToTest);
        list.add(RecipeToTest2);
        list.add(RecipeToTest3);

        Mockito.when(recipeRepository.findAll()).thenReturn(list);

        List<Recipe> returnedRecipeList = recipeService.retrieveAllRecipes();
        Assert.assertEquals(returnedRecipeList.size(), 3);

    }

}
