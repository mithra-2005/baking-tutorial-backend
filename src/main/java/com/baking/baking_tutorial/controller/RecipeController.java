package com.baking.baking_tutorial.controller;

import com.baking.baking_tutorial.entity.Recipe;
import com.baking.baking_tutorial.entity.RecipeIngredient;
import com.baking.baking_tutorial.entity.RecipeStep;
import com.baking.baking_tutorial.repository.RecipeRepository;
import com.baking.baking_tutorial.repository.RecipeIngredientRepository;
import com.baking.baking_tutorial.repository.RecipeStepRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "*")
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository ingredientRepository;
    private final RecipeStepRepository stepRepository;


    public RecipeController(
            RecipeRepository recipeRepository,
            RecipeIngredientRepository ingredientRepository,
            RecipeStepRepository stepRepository) {

        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.stepRepository = stepRepository;
    }


    // =========================================
    // GET ALL RECIPES
    // =========================================

    @GetMapping
    public List<Recipe> getAllRecipes() {

        return recipeRepository.findAll();
    }


    // =========================================
    // GET RECIPES BY CATEGORY
    // =========================================

    @GetMapping("/category/{category}")
    public List<Recipe> getRecipesByCategory(
            @PathVariable String category) {

        return recipeRepository
                .findByCategoryIgnoreCase(category);
    }


    // =========================================
    // GET RECIPE BY ID
    // =========================================

    @GetMapping("/{id}")
    public Map<String, Object> getRecipeById(
            @PathVariable int id) {

        Recipe recipe =
                recipeRepository.findById(id).orElse(null);

        if (recipe == null) {
            return null;
        }


        // Get ingredients
        List<RecipeIngredient> ingredients =
                ingredientRepository.findByRecipeId(id);


        // Get recipe steps
        List<RecipeStep> steps =
                stepRepository.findByRecipeIdOrderByStepNumber(id);


        Map<String, Object> response =
                new HashMap<>();


        // =========================================
        // BASIC RECIPE INFORMATION
        // =========================================

        response.put("id", recipe.getId());
        response.put("title", recipe.getTitle());
        response.put("description", recipe.getDescription());
        response.put("category", recipe.getCategory());
        response.put("instructions", recipe.getInstructions());
        response.put("imageUrl", recipe.getImageUrl());


        // =========================================
        // DETAILED RECIPE INFORMATION
        // =========================================

        response.put("prepTime", recipe.getPrepTime());
        response.put("cookTime", recipe.getCookTime());
        response.put("servings", recipe.getServings());
        response.put("difficulty", recipe.getDifficulty());
        response.put("temperature", recipe.getTemperature());
        response.put("tips", recipe.getTips());


        // =========================================
        // INGREDIENTS
        // =========================================

        response.put("ingredients", ingredients);


        // =========================================
        // STEP-BY-STEP INSTRUCTIONS
        // =========================================

        response.put("steps", steps);


        return response;
    }


    // =========================================
    // ADD RECIPE
    // =========================================

    @PostMapping
    public Recipe addRecipe(
            @RequestBody Recipe recipe) {

        return recipeRepository.save(recipe);
    }


    // =========================================
    // UPDATE RECIPE
    // =========================================

    @PutMapping("/{id}")
    public Recipe updateRecipe(
            @PathVariable int id,
            @RequestBody Recipe recipe) {

        Recipe existingRecipe =
                recipeRepository.findById(id).orElse(null);

        if (existingRecipe != null) {

            existingRecipe.setTitle(
                    recipe.getTitle());

            existingRecipe.setDescription(
                    recipe.getDescription());

            existingRecipe.setCategory(
                    recipe.getCategory());

            existingRecipe.setInstructions(
                    recipe.getInstructions());

            existingRecipe.setImageUrl(
                    recipe.getImageUrl());

            existingRecipe.setPrepTime(
                    recipe.getPrepTime());

            existingRecipe.setCookTime(
                    recipe.getCookTime());

            existingRecipe.setServings(
                    recipe.getServings());

            existingRecipe.setDifficulty(
                    recipe.getDifficulty());

            existingRecipe.setTemperature(
                    recipe.getTemperature());

            existingRecipe.setTips(
                    recipe.getTips());


            return recipeRepository.save(
                    existingRecipe);
        }

        return null;
    }


    // =========================================
    // DELETE RECIPE
    // =========================================

    @DeleteMapping("/{id}")
    public String deleteRecipe(
            @PathVariable int id) {

        recipeRepository.deleteById(id);

        return "Recipe deleted successfully";
    }
}