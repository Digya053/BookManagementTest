package com.bookmanagement.servicelayer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bookmanagement.model.BookManagement;
import com.bookmanagement.repository.BookManagementRepository;

@Repository
public class BookManagementServiceLayer {
	
	@Autowired
	public BookManagementRepository br;
	
	public List<BookManagement> all() {
		return br.findAll();
	}
	
	public List<BookManagement> first(String firstName){
		return br.findByFirstName(firstName);
		
	}
	
	public List<BookManagement> firstAndLast(String firstName,String lastName){
		return br.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<BookManagement> id(String id){
		return br.findById(id);
	}
	
	public BookManagement insert(BookManagement m){
		return br.save(m);
	}
	
	public String delete(String id){
		br.delete(id);
		return "DELETED SUCCESSFULLY";
		
	}
	
	public String update(String id, BookManagement mn){
		BookManagement bm = br.findOne(id);
		bm.setFirstName(mn.getFirstName());
		bm.setLastName(mn.getLastName());
		bm.setBooksBorrowed(mn.getBooksBorrowed());
		bm.setDescription(mn.getDescription());
		br.save(bm);
		return "UPDATED SUCCESSFULLY";
	}
}
		
		
		
		
		
		

