package com.mesarikaya.recipe.services;

import com.mesarikaya.recipe.dataRepositories.RecipeRepository;
import com.mesarikaya.recipe.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipe() {
        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipe -> {recipeSet.add(recipe);});
        return recipeSet;
    }
}
