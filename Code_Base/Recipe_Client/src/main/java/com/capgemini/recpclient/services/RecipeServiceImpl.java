package com.capgemini.recpclient.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.capgemini.recpclient.model.Recipes;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public List<Recipes> getAllRecipes() {
		// TODO Auto-generated method stub
		List<Recipes> recpList = new ArrayList<Recipes>();

		try {
			ResponseEntity<List<Recipes>> claimResponse = restTemplate().exchange("http://localhost:2000/fetchRecipes",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<Recipes>>() {
					});
			if (claimResponse != null && claimResponse.hasBody()) {

				recpList = claimResponse.getBody();
			}

		} catch (HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return recpList;

	}

	public void addRecipe(Recipes recp) throws Exception {

	    restTemplate().postForObject("http://localhost:2000/addrecipe", recp, Recipes.class);

	}

	public Recipes getRecipe(int id) throws Exception {
		Recipes  recipe = restTemplate().getForObject("http://localhost:2000/fetchRecipe/{id}", Recipes.class, id);
		return recipe;
	}

	public void updateRecipe(Recipes recp) {
		try {
			restTemplate().put("http://localhost:2000/updateRecipe/{id}", recp, recp.getId());

		} catch (HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}

	}

	public void deleteRecipe(int id) throws Exception {
	
			restTemplate().delete("http://localhost:2000/deleteRecipe/{id}", id);
		
	}

}
