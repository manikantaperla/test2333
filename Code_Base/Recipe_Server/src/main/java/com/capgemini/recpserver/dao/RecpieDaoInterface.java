package com.capgemini.recpserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.recpserver.entity.Recipes;

@Repository
public interface RecpieDaoInterface extends JpaRepository<Recipes, Integer> {

}
