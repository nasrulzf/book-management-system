package id.nasrul.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import id.nasrul.bms.entity.Author;
import id.nasrul.bms.entity.Book;
import id.nasrul.bms.entity.Category;
import id.nasrul.bms.entity.Publisher;
import id.nasrul.bms.service.AuthorService;
import id.nasrul.bms.service.BookService;
import id.nasrul.bms.service.CategoryService;
import id.nasrul.bms.service.PublisherService;

@Controller
public class IndexController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PublisherService publisherService;
	
	@RequestMapping("/index")
	public String getIndex(Model model){
		
		Page<Author> pageAuthor = authorService.findAll(0, 5, Direction.DESC, "id");
		model.addAttribute("listAuthor", pageAuthor.getContent());
		
		Page<Book> pageBook = bookService.findAll(0, 5, Direction.DESC, "addedDate");
		model.addAttribute("listBook", pageBook.getContent());
		
		Page<Category> pageCategory = categoryService.findAll(0, 5, Direction.DESC, "id");
		model.addAttribute("listCategory", pageCategory.getContent());
		
		Page<Publisher> pagePublisher = publisherService.findAll(0, 5, Direction.DESC, "id");
		model.addAttribute("listPublisher", pagePublisher.getContent());
		
		return "index";
	}
	
}
