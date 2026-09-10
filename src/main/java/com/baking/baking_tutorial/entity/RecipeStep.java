package com.baking.baking_tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_steps")
public class RecipeStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int recipeId;

    private int stepNumber;

    private String stepTitle;

    private String stepDescription;


    // Default constructor
    public RecipeStep() {
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }


    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }


    public String getStepTitle() {
        return stepTitle;
    }

    public void setStepTitle(String stepTitle) {
        this.stepTitle = stepTitle;
    }


    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }
}