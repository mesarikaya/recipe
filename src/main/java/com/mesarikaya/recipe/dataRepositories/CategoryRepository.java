package com.mesarikaya.recipe.dataRepositories;

import com.mesarikaya.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}