package com.mesarikaya.recipe.services;

import com.mesarikaya.recipe.commands.RecipeCommand;
import com.mesarikaya.recipe.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipe();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(Long id);
    void deleteById(Long idToDelete);
}
