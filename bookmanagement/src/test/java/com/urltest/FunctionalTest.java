package com.urltest;

import org.testng.annotations.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import com.bookmanagement.BookmanagementApplication;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;


@ContextConfiguration(classes = BookmanagementApplication.class)
public class FunctionalTest extends AbstractTestNGSpringContextTests {
  
	@Test
	public void getAll(){
		System.out.println("****************** inside getAll()******");
		given().when().get("http://localhost:8090/books/all").then().statusCode(200);
		
	}
	@Test
	public void getFirstName(){
		System.out.println("*********************inside getFirstName()***************");
		String firstName= "Sylvi";
	    given().when().get("http://localhost:8090/books/firstName?firstName="+firstName).then().statusCode(200);
	    
	  }
	
	@Test
	public void getFirstAndLastName(){
		System.out.println("****************************inside getFirstNameAndLastName**********");
		String firstName = "Prashila";
		String lastName = "Shrestha";
		given().when().get("http://localhost:8090/books/firstNameAndlastName?firstName="+firstName+"&lastName="+lastName).then().statusCode(200);
	}
	
	@Test
	public void getDelete(){
		System.out.println("*************************inside curl delete***********");
		
		}
	
	@Test(groups ="Posts")
	public void InsertNewPosts(){
		Map<String,String> post = new HashMap<String,String>();
		post.put("firstName", "Nisha");
		post.put("lastName", "Poudel");
		given().contentType("application/json").body(post).
		when().post("http://localhost:8090/books").then()
		.statusCode(200);
	}
	
	@Test(groups ="Get")
	public void getMethodTest(){
		given().when().get("http://localhost:8090/books/all").then()
		.statusCode(200);
	}
	
	@Test(groups = "Delete")
	public void deleteMethodTest(){
		given().pathParam("id","582ac37fd4275a0ce2e87860").when().delete("http://localhost:8090/books/{id}").then().statusCode(200);
	}
	
	
	@Test(groups = "post")
	public void putMethodTest(){
		Map<String,String> uppost = new HashMap<String,String>();
		uppost.put("firstName","Nishan");
		uppost.put("lastName","Pantha");
		uppost.put("booksBorrowed", "Django");
		uppost.put("description", "This will make your web learning fun.");
		given().contentType("application/json").body(uppost).
        given().pathParam("id","582ad5787ece9a16e699cd9c").when().put("http://localhost:8090/books/{id}").then().statusCode(200);
	}

@Test
public void formTest(){
	given().
    auth().form("Digya", "Acharya").
when().
    get("http://localhost:8090/form").
then().
    statusCode(200);
}

@Test
public void idTest(){
	given().
	auth().form("id","582461faacb8806645cf5264").
	when().
	get("http://localhost:8090/idd").
	then().
	statusCode(200);
		
}
}
	
