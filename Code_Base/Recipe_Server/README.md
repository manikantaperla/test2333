

## Prerequisites
* Install Eclipse/STS and  Maven plugin
* Set up Eclipse Preferences
*Select Maven
*check on "Download Artifact Sources"
*check on "Download Artifact JavaDoc"

## Technologies
Project is created with:
* JAVA 8
* Spring boot with JPA
* embedded databse h2




# why spring boot

*The main goal of Spring Boot Framework is to reduce Development, Unit Test and Integration Test time 
and to ease the development of Production ready web applications very easily compared to existing Spring 
Framework, which really takes more time. To provide some defaults to quick start new projects within no time.

*Spring Boot enables building production-ready applications quickly and provides non-functional features: 
Embedded servers which are easy to deploy with the containers. It helps in monitoring the multiples components. 
It helps in configuring the components externally

# Why JPA

JPA is a Java specification for managing relational data in Java applications. It allows us to access and 
persist data between Java object/ class and relational database. JPA follows Object-Relation Mapping (ORM). It is a 
set of interfaces. It also provides a runtime EntityManager API for processing queries and transactions on the objects
 against the database. It uses a platform-independent object-oriented query 
language JPQL (Java Persistent Query Language)


# Spring Data JPA

Spring data JPA comes with inbuilt methods for all the required crud operations

We have to declare the interface (RecpieDaoInterface) in this project which extends the JPA repository

For More info : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#project 



# Recipe Api

Backend (API + database management) for the Recipe Mangement  project. It allow  users to read,update,delete,create recipes


## Setup

To run this project, import the project locally to your eclipse/STS

* Import the project into your eclipse/STS

*  Right click on project update project (this will load the required dependencies to run the application)


* This project comes with a  data.sql(which contains the querys for creating table and to insert one sample record)

## how to test in local

* Right click on the file RecipeServerApplication and run as java application (using eclipse)

* Right click  on the project and run as spring boot App(Using java)

*By default, Spring boot applications start with embedded tomcat server

* the port number for the server is '2000' maintained in (application.properties)

* install post man plugin from chrome


# urls to test locally from postman

* http://localhost:2000/addrecipe(this url is to add a recipe)

(sample json )


    {
        "recpName": "Test Recipe",
        "recpInd": "Yes",
        "recpCount": "3",
        "recpPrepa": "Test",
        "recpIng": "Test",
        "recpDateTime": "2017-09-25 18:07"
    }
    
  * http://localhost:2000/updateRecipe/3 (this url is to update a recipe)

(sample json body)


    {   "id": 2,
        "recpName": "Test Recipe",
        "recpInd": "Yes",
        "recpCount": "3",
        "recpPrepa": "Test",
        "recpIng": "Test",
        "recpDateTime": "2017-09-25 18:07"
    }



* http://localhost:2000/fetchRecipe/1 (this url is to fetch the one recipe from the recipes)


* http://localhost:2000/deleteRecipe/2 (this url is to delete a particular recipe)




 




