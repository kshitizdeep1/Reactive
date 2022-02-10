package com.omnicell.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Recipe implements Persistable<Long>{
	/**
	 * 
	 */
	@Id
	private Long id;
    private String name;
    private String image;
    private String category;
    private String label;
    private String price;
    private String description;
    @Transient
    private boolean newRecipe;

    @Override
    @Transient
    public boolean isNew() {
        return this.newRecipe || id == null;
    }

    public Recipe setAsNew() {
        this.newRecipe = true;
        return this;
    }
    
}
