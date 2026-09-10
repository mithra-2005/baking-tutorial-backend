package com.baking.baking_tutorial.repository;

import com.baking.baking_tutorial.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository
        extends JpaRepository<Review, Integer> {

    List<Review> findByRecipeIdOrderByReviewDateDesc(int recipeId);
}