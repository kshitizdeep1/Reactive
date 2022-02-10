package com.omnicell.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnicell.entity.Recipe;
import com.omnicell.entity.RecipeList;
import com.omnicell.repository.RecipeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
//@CacheConfig(cacheNames = {"Recipe"})
public class RecipeService {

	@Autowired
	RecipeRepository recipeRepository;

	// @Cacheable(value="Recipe", key = "#id", unless="#result == null")
	public Mono<Recipe> getRecipeById(Long id) {
		return recipeRepository.findById(id);
	}

	public Mono<Recipe> getImageByID(Long id) {
		return recipeRepository.findById(id);
	}

	public Mono<Recipe> addRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public Mono<Recipe> updateRecipe(Recipe recipe, Long id) {
		// TODO Auto-generated method stub
		return recipeRepository.findById(id).flatMap(existingRecipe -> {
			if (recipe.getCategory() != null)
				existingRecipe.setCategory(recipe.getCategory());
			if (recipe.getDescription() != null)
				existingRecipe.setDescription(recipe.getDescription());
			if (recipe.getImage() != null)
				existingRecipe.setImage(recipe.getImage());
			if (recipe.getLabel() != null)
				existingRecipe.setLabel(recipe.getLabel());
			if (recipe.getName() != null)
				existingRecipe.setName(recipe.getName());
			if (recipe.getPrice() != null)
				existingRecipe.setPrice(recipe.getPrice());
			return recipeRepository.save(existingRecipe);
		});

	}

	public Mono<Void> deleteRecipeById(Long id) {
		// TODO Auto-generated method stub
		return recipeRepository.deleteById(id);
		//returns Mono<Recipe>
		//return recipeRepository.findById(id).flatMap(recipe->{return recipeRepository.delete(recipe).then(Mono.just(recipe));});
		
	}

	public Flux<Recipe> getAllRecipe() {
		// TODO Auto-generated method stub
		Flux<Recipe> listRecipe = recipeRepository.findAll();
		return listRecipe;
	}
	//@Transactional
	public Flux<RecipeList> initialAdd(List<Recipe> recipeList) {
		return recipeRepository.saveAll(recipeList).thenMany(Flux.just(new RecipeList(recipeList)));

	}

}
