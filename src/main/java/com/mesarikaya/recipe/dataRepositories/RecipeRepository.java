package com.mesarikaya.recipe.dataRepositories;

import com.mesarikaya.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
