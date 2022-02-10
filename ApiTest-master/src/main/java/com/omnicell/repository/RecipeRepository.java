package com.omnicell.repository;



import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.omnicell.entity.Recipe;

public interface RecipeRepository extends ReactiveCrudRepository<Recipe, Long> {

	
}
