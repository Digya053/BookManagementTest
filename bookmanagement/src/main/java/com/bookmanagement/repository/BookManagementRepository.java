package com.bookmanagement.repository;
 import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookmanagement.model.BookManagement;


public interface BookManagementRepository extends MongoRepository<BookManagement, String>
{
	List<BookManagement> findByFirstName(String firstName);
	List<BookManagement> findById(String id);
	List<BookManagement> findByFirstNameAndLastName(String firstName, String lastName);
	
	
	
	
	

}
