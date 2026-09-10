package com.baking.baking_tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private String category;

    private String ingredients;

    private String instructions;

    private String imageUrl;

    private String prepTime;

    private String cookTime;

    private int servings;

    private String difficulty;

    private String temperature;

    private String tips;


    // Default constructor
    public Recipe() {
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }


    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }


    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }


    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }


    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }


    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }


    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}