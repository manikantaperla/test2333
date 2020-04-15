package com.capgemini.recpserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.recpserver.entity.Users;

@Repository
public interface UserDaoInterface extends JpaRepository<Users, Integer> {

}
