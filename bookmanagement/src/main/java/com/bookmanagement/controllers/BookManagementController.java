package com.bookmanagement.controllers;
import com.bookmanagement.servicelayer.BookManagementServiceLayer;

import  com.bookmanagement.model.*;
import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class BookManagementController {
	@RequestMapping("/home")
	public String home(){
		return "index";
	}
	
	@Controller
	public class Controllerform {

	    @GetMapping("/form")
	    public String greetingForm(Model model) {
	        model.addAttribute("form", new BookManagement());
	        return "form";
	    }

	    @PostMapping("/form")
	    public String greetingSubmit(@ModelAttribute BookManagement form, BindingResult bindingResult)
	    {
	    	 if (bindingResult.hasErrors()) {
	             return "form";
	         }
	    	 String firstName1 = form.getFirstName();
	    	 String lastName1 = form.getLastName();
	        return "redirect:/books/firstNameAndlastName?firstName="+firstName1+"&lastName="+lastName1;
	    }
	    @Controller
		public class Controllerid {

		    @GetMapping("/idd")
		    public String greetingForm(Model model) {
		        model.addAttribute("id", new BookManagement());
		        return "id";
		    }

		    @PostMapping("/idd")
		    public String greetingSubmit(@ModelAttribute BookManagement idd, BindingResult bindingResult)
		    {
		    	 if (bindingResult.hasErrors()) {
		             return "id";
		         }
		    	 String id1=idd.getId();
		        return "redirect:/books/"+id1;
		    }

@RestController
@RequestMapping("/books")
public class information{
	@Autowired
	BookManagementServiceLayer bs;
	
	@RequestMapping("/all")
	public List<BookManagement> all(){
		List<BookManagement> books =  bs.all();
		return books;
		
	}
	@RequestMapping("/firstName")
	public List<BookManagement> first(@RequestParam String firstName){
		return bs.first(firstName);
	}

	@RequestMapping("/firstNameAndlastName")
	public List<BookManagement> firstAndlast(@RequestParam String firstName, @RequestParam String lastName){
		return bs.firstAndLast(firstName, lastName);
	}
	
	@RequestMapping("/{id}")
	public List<BookManagement> id(@PathVariable String id){
		return bs.id(id);
	}
	
	@RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String id){
		return bs.delete(id);
	}
	
	@RequestMapping (value = "", method = RequestMethod.POST)
	public BookManagement insert(@RequestBody BookManagement bmi){
		return bs.insert(bmi);
	}

	@RequestMapping (value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable String id, @RequestBody BookManagement bmu){
	     return bs.update(id, bmu);
	
}
	
}
}
}
}


