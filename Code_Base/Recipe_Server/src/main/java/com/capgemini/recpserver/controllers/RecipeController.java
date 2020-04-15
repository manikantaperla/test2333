package com.capgemini.recpserver.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.recpserver.dao.RecpieDaoInterface;
import com.capgemini.recpserver.entity.Recipes;



/**
*  
*  Rest controller method to handle all Http requests(GET,POST,UPDATE,DELETE) for recipes
*
*
* @author  Mutyala Manikanta Perla
* @version 1.0
 
*/


@RestController
public class RecipeController {
	
	@Autowired
	private RecpieDaoInterface repository;
	
	
	/**
	 Method to fetch all recipes
	 */
	
	
	@PostMapping(value= "/addrecipe" ,consumes= {"application/xml","application/json"})
	public ResponseEntity<Recipes>  addAlien(@RequestBody Recipes rec) {
		
		if(rec == null) {
			
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(repository.save(rec));
	}
	
	
	/**
	 Method to fetch all recipes
	 */
	
	
	@RequestMapping(value="/fetchRecipes")
	public ResponseEntity<List<Recipes>>  fetchAll() {
		
	return  ResponseEntity.ok(repository.findAll());
	}
	

	/**
	 Method to fetch a particular recipe
	 */
	
	@RequestMapping(value="/fetchRecipe/{id}")
	public ResponseEntity<Recipes> fetchRecipe(@PathVariable int id) {
		
		//System.out.println("value is presrent");
		 Optional<Recipes> recp = repository.findById(id);
	     if (!recp.isPresent()) {
	         return ResponseEntity.badRequest().build();
	     }
	     
	     return ResponseEntity.ok(recp.get());
	
	}
	
	/**
	 Method to update  a  recipe
	 */
	
	 @PutMapping("/updateRecipe/{id}")
	 Recipes updateRecipe(@RequestBody Recipes newrecp, @PathVariable int id) {
	 
	        return repository.findById(id).map(recp -> {
	        	recp.setRecpName(newrecp.getRecpName());
	        	recp.setRecpPrepa(newrecp.getRecpPrepa());
	        	recp.setRecpDateTime(newrecp.getRecpDateTime());
	        	recp.setRecpCount(newrecp.getRecpCount());
	        	recp.setRecpInd(newrecp.getRecpInd());
	        	recp.setRecpIng(newrecp.getRecpIng());
	            return repository.save(recp);
	        }).orElseGet(() -> {
	       
	            return repository.save(newrecp);
	        });
	    }
	
	 /**
	 Method to delete  a  recipe
	 */
	 
	@DeleteMapping("/deleteRecipe/{id}")
   public  ResponseEntity<Recipes> deleteEmployee(@PathVariable int id) {
		
		if (!repository.findById(id).isPresent()) {
           return  ResponseEntity.badRequest().build();
        }
		
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
		
		
    }
	
}
