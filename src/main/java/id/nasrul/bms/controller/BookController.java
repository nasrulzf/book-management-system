package id.nasrul.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import id.nasrul.bms.entity.Book;
import id.nasrul.bms.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@ModelAttribute("book")
	public Book construct(){
		return new Book();
	}
	
}
