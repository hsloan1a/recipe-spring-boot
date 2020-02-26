package com.recipeexample.demo;

import com.recipeexample.demo.controller.RecipeController;
import com.recipeexample.demo.model.AmountCatagory;
import com.recipeexample.demo.model.Ingredient;
import com.recipeexample.demo.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipeApplicationE2eTests {

    MockMvc mockMvc;

    @Autowired
    private RecipeController recipeController;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        this.mockMvc = standaloneSetup(this.recipeController).build();
    }

    @Test
    public void createRecipeTest() throws Exception {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("2", AmountCatagory.cup, "sugar"));
        Recipe RecipeToTest = new Recipe("No Bake Cookies", ingredients, "Mix and put on wax paper.");

        recipeController.add(RecipeToTest);

        mockMvc.perform(get("/all_recipe").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].title").exists());

    }
}