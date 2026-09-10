package com.baking.baking_tutorial.controller;

import com.baking.baking_tutorial.entity.Review;
import com.baking.baking_tutorial.repository.ReviewRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    /* =========================================
       GET REVIEWS FOR A RECIPE
       
       Example:
       GET /api/reviews/4
    ========================================= */

    @GetMapping("/{recipeId}")
    public List<Review> getReviews(
            @PathVariable int recipeId) {

        return reviewRepository
                .findByRecipeIdOrderByReviewDateDesc(recipeId);
    }


    /* =========================================
       ADD NEW REVIEW

       Example:
       POST /api/reviews
    ========================================= */

    @PostMapping
    public Review addReview(
            @RequestBody Review review) {

        return reviewRepository.save(review);
    }


    /* =========================================
       DELETE REVIEW
       
       Example:
       DELETE /api/reviews/1
    ========================================= */

    @DeleteMapping("/{id}")
    public String deleteReview(
            @PathVariable int id) {

        if (reviewRepository.existsById(id)) {

            reviewRepository.deleteById(id);

            return "Review deleted successfully";

        }

        return "Review not found";
    }

}