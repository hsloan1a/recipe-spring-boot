package com.recipeexample.demo.controller;

import com.recipeexample.demo.model.AmountCatagory;
import com.recipeexample.demo.model.Ingredient;
import com.recipeexample.demo.model.Recipe;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class RecipeControllerTest {

    @Autowired
    RecipeController recipeController;

    @BeforeEach
    public void clear() {
        recipeController.deleteAll();
    }


    @Test
    public void testListAllRecipe() {
        List<Recipe> list = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("2", AmountCatagory.cup, "sugar"));
        Recipe RecipeToTest = new Recipe("No Bake Cookies", ingredients, "Mix and put on wax paper.");
        Recipe RecipeToTest2 = new Recipe("No Bake Cookies 2", ingredients, "Mix and put on wax paper.");
        ingredients.add(new Ingredient("1/4", AmountCatagory.teaspoon, "cocoa"));
        Recipe RecipeToTest3 = new Recipe("No Bake Cookies 3", ingredients, "Same as above.");

        list.add(RecipeToTest);
        list.add(RecipeToTest2);
        list.add(RecipeToTest3);

        recipeController.add(RecipeToTest);
        recipeController.add(RecipeToTest2);
        recipeController.add(RecipeToTest3);

        List<Recipe> returnedList = recipeController.listAll();
        Assert.assertEquals(3, returnedList.size());
    }

    @Test
    public void testCreateRecipe() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("2", AmountCatagory.cup, "sugar"));
        Recipe RecipeToTest = new Recipe("No Bake Cookies 4", ingredients, "Mix and put on wax paper.");

        Recipe recipeResponse = recipeController.add(RecipeToTest);
        Assert.assertEquals(RecipeToTest, recipeResponse);

    }


}
