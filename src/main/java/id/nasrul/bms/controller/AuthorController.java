package id.nasrul.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.nasrul.bms.entity.Author;
import id.nasrul.bms.repo.AuthorRepo;
import id.nasrul.bms.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@ModelAttribute("author")
	public Author construct(){
		return new Author();
	}
	
	@RequestMapping("/author")
	public String authorIndex(Model model){
		Page<Author> pageAuthor = authorService.findAll(0, 10, Direction.DESC, "id");
		
		model.addAttribute("listAuthor", pageAuthor.getContent());
		model.addAttribute("curPages", pageAuthor.getNumber() + 1);
		model.addAttribute("totalPages", pageAuthor.getTotalPages());
		model.addAttribute("hasNext", pageAuthor.hasNextPage());
		model.addAttribute("hasPrev", pageAuthor.hasPreviousPage());
		
		return "authors";
	}
	
	@RequestMapping("/author/{num}")
	public String authorPages(Model model, @PathVariable int num){
		Page<Author> pageAuthor = authorService.findAll(num - 1, 10, Direction.DESC, "id");
		
		model.addAttribute("listAuthor", pageAuthor.getContent());
		model.addAttribute("curPages", pageAuthor.getNumber() + 1);
		model.addAttribute("totalPages", pageAuthor.getTotalPages());
		model.addAttribute("hasNext", pageAuthor.hasNextPage());
		model.addAttribute("hasPrev", pageAuthor.hasPreviousPage());
		
		return "authors";
	}
	
	@RequestMapping("/author/form")
	public String authorFormAdd(){
		return "authorsForm";
	}
	
	@RequestMapping(value = "/author/form", method = RequestMethod.POST)
	public String doAuthorAdd(@ModelAttribute("author") Author author){
		authorService.save(author);
		return "redirect:/author.htm";
	}
	
	@RequestMapping("/author/form/{id}")
	public String authorFormEdit(Model model, @PathVariable int id){
		model.addAttribute("author", authorService.findOne(id));
		return "authorsForm";
	}
	
	@RequestMapping(value = "/author/form/{id}", method = RequestMethod.POST)
	public String doAuthorEdit(Model model, @PathVariable int id, @ModelAttribute("author") Author author){
		authorService.save(author);
		return "redirect:/author.htm";
	}
	
	@RequestMapping("/author/delete/{id}")
	public String doDelete(Model model, @PathVariable int id){
		authorService.delete(id);
		return "redirect:/author.htm";
	}
	
}
