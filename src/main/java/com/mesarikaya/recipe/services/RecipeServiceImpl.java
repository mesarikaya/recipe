package com.mesarikaya.recipe.services;

import com.mesarikaya.recipe.commands.RecipeCommand;
import com.mesarikaya.recipe.converters.RecipeCommandToRecipe;
import com.mesarikaya.recipe.converters.RecipeToRecipeCommand;
import com.mesarikaya.recipe.dataRepositories.RecipeRepository;
import com.mesarikaya.recipe.model.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipe() {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipe -> {recipeSet.add(recipe);});
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe Not Found");
        }
        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }


    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }
}
