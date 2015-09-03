package id.nasrul.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/books")
	public String getListBook(Model model){
	
		Page<Book> pageBook = bookService.findAll(0, 10, Direction.DESC, "addedDate");
		
		model.addAttribute("listBook", pageBook.getContent());
		model.addAttribute("curPages", pageBook.getNumber() + 1);
		model.addAttribute("totalPages", pageBook.getTotalPages());
		model.addAttribute("hasNext", pageBook.hasNextPage());
		model.addAttribute("hasPrev", pageBook.hasPreviousPage());
		
		return "books";
	}
	
	@RequestMapping("/books/{num}")
	public String getBookPaging(Model model, @PathVariable int num){
	
		Page<Book> pageBook = bookService.findAll(num - 1, 10, Direction.DESC, "addedDate");
		
		model.addAttribute("listBook", pageBook.getContent());
		model.addAttribute("curPages", pageBook.getNumber() + 1);
		model.addAttribute("totalPages", pageBook.getTotalPages());
		model.addAttribute("hasNext", pageBook.hasNextPage());
		model.addAttribute("hasPrev", pageBook.hasPreviousPage());
		
		return "books";
	}
	
	@RequestMapping("/book/form")
	public String getBookForm(){
		return "booksForm";
	}
	
	@RequestMapping("/book/form/{isbn}")
	public String getBookUpdate(Model model, @PathVariable String isbn){
		model.addAttribute("book", bookService.findOne(isbn));
		return "booksForm";
	}
	
	
	
}
