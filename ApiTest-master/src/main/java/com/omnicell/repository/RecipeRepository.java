package com.omnicell.repository;



import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.omnicell.entity.Recipe;
import com.omnicell.entity.RecipeList;

import reactor.core.publisher.Mono;

public interface RecipeRepository extends ReactiveCrudRepository<Recipe, Long> {

	
}
