package com.capgemini.recpserver.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.capgemini.recpserver.RecipeServerApplication;
import com.capgemini.recpserver.entity.Recipes;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = RecipeServerApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTesting {
	
	 @LocalServerPort
	    private int port;
	
	    @Autowired
	    private TestRestTemplate restTemplate;
	 

	 
	    
	/*
	 * This method is to test adding of a recipe ,response code of 200 is expected
	 * when we send the request
	 */

	@Sql({ "data.sql" })
    @Test
    public void testAddRecipe() {
        Recipes recp = new Recipes();
        
        recp.setRecpName("test1");
    	recp.setRecpPrepa("test2");
    	recp.setRecpDateTime("22/12/1990");
    	recp.setRecpCount("12");
    	recp.setRecpInd("No");
    	recp.setRecpIng("Oil");
        
        ResponseEntity<String> responseEntity = this.restTemplate
            .postForEntity("http://localhost:" + port + "/addrecipe", recp, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
	/*
	 * This method is to test adding of a recipe ,response code of 200 is expected
	 * when we send the request
	 */
	 @Test
	    public void testAddRecipe2() {
	        Recipes recp = new Recipes();
	        
	        recp.setRecpName("test3");
	    	recp.setRecpPrepa("test3");
	    	recp.setRecpDateTime("22/12/1990");
	    	recp.setRecpCount("12");
	    	recp.setRecpInd("yes");
	    	recp.setRecpIng("list");
	        
	        ResponseEntity<String> responseEntity = this.restTemplate
	            .postForEntity("http://localhost:" + port + "/addrecipe", recp, String.class);
	        assertEquals(200, responseEntity.getStatusCodeValue());
	    }
	
	 
	 /*
		 * This method is to test adding of a recipe ,response code of 200 is expected
		 * when we send the request
		 */
		 @Test
		    public void testAddRecipe3() {
		        Recipes recp = new Recipes();
		        
		        recp.setRecpName("test3");
		    	recp.setRecpPrepa("test3");
		    	recp.setRecpDateTime("22/12/1990");
		    	recp.setRecpCount("12");
		    	recp.setRecpInd("yes");
		    	recp.setRecpIng("list");
		        
		        ResponseEntity<String> responseEntity = this.restTemplate
		            .postForEntity("http://localhost:" + port + "/addrecipe", recp, String.class);
		        assertEquals(200, responseEntity.getStatusCodeValue());
		    }
		
	 
	 /*
		 * This method is for a fetching a recipe ,response code of 200 is expected
		 * when we send a valid  request
		 */
	
	 @Test
	 public void testFetchRecipe() {	        
	        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("http://localhost:" + port + "/fetchRecipe/1",String.class);
	        assertEquals(200, responseEntity.getStatusCodeValue());
	    }
	 
	 
	 /*
		 * This method is to test adding of a recipe ,response code of 400 is expected
		 * when we send a IN valid  request
		 */
	
	 @Test
	 public void testFetchRecipe2() {	        
	        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("http://localhost:" + port + "/fetchRecipe/100",String.class);
	        assertEquals(400, responseEntity.getStatusCodeValue());
	    }
	 
	 /*
		 * This method is to fetch all recipes ,response code of 200 is expected
		 * when we send a valid  request
		 */
	 @Test
	 public void FetchAllRecipes() {	        
	        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("http://localhost:" + port + "/fetchRecipes",String.class);
	        assertEquals(200, responseEntity.getStatusCodeValue());
	    }
	 
	
}

