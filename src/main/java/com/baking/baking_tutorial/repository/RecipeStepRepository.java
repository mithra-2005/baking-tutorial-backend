package com.baking.baking_tutorial.repository;

import com.baking.baking_tutorial.entity.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeStepRepository
        extends JpaRepository<RecipeStep, Integer> {

    List<RecipeStep> findByRecipeIdOrderByStepNumber(int recipeId);
}