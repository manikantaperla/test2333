package com.capgemini.recpclient.services;

import java.util.List;

import com.capgemini.recpclient.model.Recipes;

public interface RecipeService {

	public List<Recipes> getAllRecipes();
	
	public void addRecipe(Recipes recp) throws Exception;
	
	public Recipes getRecipe(int id) throws Exception;
	
	public void updateRecipe(Recipes recp);
	
	public void deleteRecipe(int id) throws Exception;
}
