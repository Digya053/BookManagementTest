package com.bookmanagement.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="book")
@XmlRootElement
public class BookManagement {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String booksBorrowed;
	private String description;
	
	
public BookManagement(){}

public BookManagement(String firstName, String lastName, String booksBorrowed, String description){
	//this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.booksBorrowed = booksBorrowed;
	this.description = description;
}

public void setId(String id){
	this.id = id;
}

public void setFirstName(String firstName){
	this.firstName = firstName;
}

public void setLastName(String lastName){
	this.lastName = lastName;
}

public void setBooksBorrowed(String booksBorrowed){
	this.booksBorrowed = booksBorrowed;
}

public void setDescription(String description){
	this.description = description;
}

public String getId(){
	return id;
}

public String getFirstName(){
	return firstName;
}

public String getLastName(){
	return lastName;
}

public String getBooksBorrowed(){
	return booksBorrowed;
}

public String getDescription(){
	return description;
}
}

