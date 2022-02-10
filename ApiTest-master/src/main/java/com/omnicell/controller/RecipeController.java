package com.omnicell.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.omnicell.entity.Recipe;
import com.omnicell.entity.RecipeList;
import com.omnicell.service.RecipeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	@Value("${recipe.url}")
	private String recipeUrl;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Recipe>> getRecipeById(@PathVariable("id") Long id) {
		Mono<Recipe> m = recipeService.getRecipeById(id);
		return m.map(k -> new ResponseEntity<>(k, HttpStatus.OK));
	}

	@GetMapping(value = "{id}/show", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<String>> getRecipeImageById(@PathVariable("id") Long id) {
		Mono<Recipe> m = recipeService.getImageByID(id);
		return m.map(k -> new ResponseEntity<>(k.getImage(), HttpStatus.OK));
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Recipe> getAllRecipe() {
		return recipeService.getAllRecipe();
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Recipe>> addRecipe(@RequestBody Recipe recipe) {
		Mono<Recipe> newrecipe = recipeService.addRecipe(recipe);
		return newrecipe.map(k -> new ResponseEntity<>(k, HttpStatus.OK));
	}

	@PostMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<RecipeList> addAllRecipe(@RequestBody List<Recipe> recipeList) {
		return recipeService.initialAdd(recipeList);
	}

	@PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Recipe>> editRecipe(@RequestBody Recipe newRecipe, @PathVariable("id") Long id) {

		Mono<Recipe> r = recipeService.updateRecipe(newRecipe, id);
		return r.map(k -> new ResponseEntity<>(k, HttpStatus.OK));
	}

	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Object> deleteRecipe(@PathVariable("id") Long id) {

		return recipeService.deleteRecipeById(id).map(k -> new ResponseEntity<>(k, HttpStatus.OK));
	}

	@PostMapping(value = "/addApi", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<RecipeList> addApi() {
		RestTemplate restTemplate = new RestTemplate();
		// System.out.println(restTemplate.getForObject(recipeUrl, RecipeList.class));
		Recipe[] recipeList = restTemplate.getForObject(recipeUrl, Recipe[].class);
		System.out.println(Arrays.toString(recipeList));
		return recipeService.initialAdd(Arrays.asList(recipeList));
	}
}
