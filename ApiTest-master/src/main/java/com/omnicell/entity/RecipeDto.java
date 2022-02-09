package com.omnicell.entity;

import lombok.Data;

@Data
public class RecipeDto {

	private String name;
	private String image;
	private String category;
	private String label;
	private String price;
	private String description;
}
