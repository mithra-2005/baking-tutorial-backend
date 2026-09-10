package com.baking.baking_tutorial.repository;

import com.baking.baking_tutorial.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeIngredientRepository
        extends JpaRepository<RecipeIngredient, Integer> {

    List<RecipeIngredient> findByRecipeId(int recipeId);
}