package com.recipes.recipes.model;

import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipesController {
    private RecipeRepository recipeRepository;

    public RecipesController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/recipes")
    Collection<Recipe> recipes() {
        return (Collection<Recipe>) recipeRepository.findAll();
    }

    @PostMapping("/recipes")
    ResponseEntity<Recipe> createRecipe(@Validated @RequestBody Recipe recipe) throws URISyntaxException {
        Recipe result = recipeRepository.save(recipe);
        return ResponseEntity.ok().body(result);
    }
}
