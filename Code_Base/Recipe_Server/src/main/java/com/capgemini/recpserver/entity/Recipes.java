package com.capgemini.recpserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "recipes")
public class Recipes {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;	
	    @Column (name ="RECPNAME")
		private String recpName;
	    @Column (name ="RECPIND")
		private String recpInd;
	    @Column (name ="RECPCOUNT")
		private String recpCount;
	    @Column (name ="RECPPREPA")
		private String recpPrepa;
	    @Column (name ="RECPING")
		private String recpIng;
	    @Column (name ="RECPDATETIME")
		private String recpDateTime;
	
		public String getRecpInd() {
			return recpInd;
		}
		public void setRecpInd(String recpInd) {
			this.recpInd = recpInd;
		}
		public String getRecpCount() {
			return recpCount;
		}
		public void setRecpCount(String recpCount) {
			this.recpCount = recpCount;
		}
		public String getRecpIng() {
			return recpIng;
		}
		public void setRecpIng(String recpIng) {
			this.recpIng = recpIng;
		}
		public String getRecpDateTime() {
			return recpDateTime;
		}
		public void setRecpDateTime(String recpDateTime) {
			this.recpDateTime = recpDateTime;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getRecpName() {
			return recpName;
		}
		public void setRecpName(String recpName) {
			this.recpName = recpName;
		}
		public String getRecpPrepa() {
			return recpPrepa;
		}
		public void setRecpPrepa(String recpPrepa) {
			this.recpPrepa = recpPrepa;
		}
		
		
	
		
	}


