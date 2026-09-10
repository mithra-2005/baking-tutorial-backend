package com.baking.baking_tutorial.repository;

import com.baking.baking_tutorial.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository
        extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByCategoryIgnoreCase(String category);
}