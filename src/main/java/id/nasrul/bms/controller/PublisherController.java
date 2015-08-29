package id.nasrul.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.nasrul.bms.entity.Publisher;
import id.nasrul.bms.repo.PublisherRepo;
import id.nasrul.bms.service.PublisherService;

@Controller
public class PublisherController {

	@Autowired
	private PublisherService publisherService;
	
	@ModelAttribute("publisher")
	public Publisher construct(){
		return new Publisher();
	}
	
	@RequestMapping("/publishers")
	public String getIndexPublisher(Model model){
		Page<Publisher> pagePublisher = publisherService.findAll(0, 10, Direction.DESC, "id");
		
		model.addAttribute("listPublisher", pagePublisher.getContent());
		model.addAttribute("curPages", pagePublisher.getNumber());
		model.addAttribute("totalPages", pagePublisher.getTotalPages());
		model.addAttribute("hasNext", pagePublisher.hasNextPage());
		model.addAttribute("hasPrev", pagePublisher.hasPreviousPage());
		
		return "publishers";
	}
	
	@RequestMapping("/publishers/{num}")
	public String getPagePublisher(Model model, @PathVariable int num){
		Page<Publisher> pagePublisher = publisherService.findAll(num - 1, 10, Direction.DESC, "id");
		
		model.addAttribute("listPublisher", pagePublisher.getContent());
		model.addAttribute("curPages", pagePublisher.getNumber() + 1);
		model.addAttribute("totalPages", pagePublisher.getTotalPages());
		model.addAttribute("hasNext", pagePublisher.hasNextPage());
		model.addAttribute("hasPrev", pagePublisher.hasPreviousPage());
		
		return "publishers";
	}
	
	@RequestMapping("/publisher/form")
	public String getFormPublisher(){
		return "publishersForm";
	}
	
	@RequestMapping(value = "/publisher/form", method = RequestMethod.POST)
	public String doAddPublisher(@ModelAttribute("publisher") Publisher publisher){
		publisherService.save(publisher);
		return "redirect:/publishers.htm";
	}
	
	@RequestMapping("/publisher/form/{id}")
	public String getUpdatePublisher(Model model, @PathVariable int id){
		model.addAttribute("publisher", publisherService.findOne(id));
		return "publishersForm";
	}
	
	@RequestMapping(value = "/publisher/form/{id}", method = RequestMethod.POST)
	public String doUpdatePublisher(Model model, @PathVariable int id, @ModelAttribute("publisher") Publisher publisher){
		publisherService.save(publisher);
		return "redirect:/publishers.htm";
	}
	
	@RequestMapping("/publisher/delete/{id}")
	public String deletePublisher(@PathVariable int id){
		publisherService.delete(id);
		return "redirect:/publishers.htm";
	}
	
}
