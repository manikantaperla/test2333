package com.capgemini.recpserver.main;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;

import com.capgemini.recpserver.RecipeServerApplication;
import com.capgemini.recpserver.dao.RecpieDaoInterface;
import com.capgemini.recpserver.entity.Recipes;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { RecipeServerApplication.class })
public class DaoTesting {

	@Autowired
	ApplicationContext context;

	@Autowired
	RecpieDaoInterface recpDao;

	/*
	 * This method is to test the dao method save and after succesful insertion the
	 * dao method should return recipe object
	 */
	@Test
	public void testInsertRecipe() {

		Recipes recp = new Recipes();
		recp.setRecpName("test1");
		recp.setRecpPrepa("test2");
		recp.setRecpDateTime("22/12/1990");
		recp.setRecpCount("12");
		recp.setRecpInd("yes");
		recp.setRecpIng("list");

		assertNotNull(recpDao.save(recp));
	}

	/*
	 * This method is to test the dao method save and after successful insertion the
	 * dao method should return recipe object
	 */
	@Test

	public void testInsertRecipe2() {
		Recipes recp = new Recipes();
		recp.setRecpName("test1");
		recp.setRecpPrepa("test2");
		recp.setRecpDateTime("22/12/1990");
		recp.setRecpCount("12");
		recp.setRecpInd("yes");
		recp.setRecpIng("list");

		assertNotNull(recpDao.save(recp));
	}

	@Test
	public void fetchall() {
		assertNotNull(recpDao.findAll());

	}

	/*
	 * This method is to test the dao method find the saved value and after
	 * successful insertion the dao method should return recipe object
	 */
	@Test
	public void testReadRecipe() {
		assertNotNull(recpDao.findById(1));

	}

}
