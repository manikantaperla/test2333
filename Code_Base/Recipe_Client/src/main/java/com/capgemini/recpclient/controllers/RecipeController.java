package com.capgemini.recpclient.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.recpclient.model.Recipes;
import com.capgemini.recpclient.services.RecipeService;
import com.capgemini.recpclient.utility.RecipeUtils;




@Controller
public class RecipeController {
	
	@Autowired(required=true)
	@Qualifier("recipeService")
	
	private RecipeService recipeService;
	
	/**
	 * This Method is used to display the home page for the application which display the list 
	 * of recipes from the databse/server 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="displayRecipes", method=RequestMethod.GET)
    public String displayRecipes(Model model) {
		List<Recipes> recpList =recipeService.getAllRecipes();
		  model.addAttribute("recpList", recpList);
		  return "recipes";         
    }
	
	
	/**
	 * This Method is to display add recipe page(jsp) to the user
	 * @param recipes
	 * @return
	 */
	@RequestMapping(value="addRecipe", method=RequestMethod.GET)
    public String addRecipe(Recipes recipes) {
		  return "addRecipe";         
    }
	
	/**
	 * once the user submits the add recipe form ,this method will be triggered  and after successful
	 * insertion user will be redirected to home page
	 * @param recipes
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addRecpValues", method=RequestMethod.POST)
    public ModelAndView addRecpValues(Recipes recipes,Model model) throws Exception {	
		recipes.setRecpDateTime(RecipeUtils.getAcceptedDate());
		recipeService.addRecipe(recipes);
		return new ModelAndView("redirect:/displayRecipes.htm");         
    }
	
	/**
	 * once the user updates the recipe ,this method will be triggered and after successful
	 *  update user will be redirected to home page 
	 * @param recipes
	 * @param model
	 * @return
	 */
	@RequestMapping(value="updateRecipe", method=RequestMethod.POST)
    public ModelAndView updateRecipe(Recipes recipes,Model model) {
		recipes.setRecpDateTime(RecipeUtils.getAcceptedDate());
		recipeService.updateRecipe(recipes);
		return new ModelAndView("redirect:/displayRecipes.htm");         
    }
	
	
	
	
	/**
	 * This Method is to display edit recipe page(jsp) to the user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="editRecipe",method=RequestMethod.GET)    
    public ModelAndView editRecipe( @RequestParam("id") int id) throws Exception{  
		Recipes recipe = recipeService.getRecipe(id);   
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editRecipe");
		mv.addObject("recipes", recipe);
        return mv;   
    }    
	

	/**
	 * This Method is to display the recipe details(jsp) to the user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="recpDetails", method=RequestMethod.GET)
    public String recpDetails( @RequestParam("id") int id, Model model) throws Exception {
		Recipes recipe = recipeService.getRecipe(id);
		model.addAttribute("recpObj", recipe);
        return "recipeDetails";            
    }
	
	/**
	 * This method is used to delete the recipe,after deletion user will be redirected to home page
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="deleteRecipe",method=RequestMethod.GET)
	public ModelAndView deleteRecipe( @RequestParam("id") int id, Model model) throws Exception {
		recipeService.deleteRecipe(id);
		return new ModelAndView("redirect:/displayRecipes.htm");  
    }
	
	
	
	
	
	
	
	/**
	 * User will be redirected to error page when he receives an http client error from the application
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(HttpClientErrorException.class)
	public ModelAndView handleClientError(HttpClientErrorException ex){
		ModelAndView model = new ModelAndView("generic_error");
		model.addObject("errMsg", "There is a server issue ,please contact your system admin");
		
		return model;

	}
	
	/**
	 * User will be redirected to error page when he receives an http Server error from the application
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(HttpServerErrorException.class)
	public ModelAndView handleServerError(HttpServerErrorException ex){
		ModelAndView model = new ModelAndView("generic_error");
		model.addObject("errMsg", "There is a server issue ,please contact your system admin");
		
		
		return model;

	}
	
	/**
	 * User will be redirected to error page when he receives an application error/exception  from the application
	 * @param ex
	 * @return
	 */
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("generic_error");
		model.addObject("errMsg", "error in application");

		return model;

	}

	
}
