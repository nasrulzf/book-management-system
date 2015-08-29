package id.nasrul.bms.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.nasrul.bms.entity.Category;
import id.nasrul.bms.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("category")
	public Category construct(){
		return new Category();
	}
	
	@RequestMapping("/categories")
	public String getIndexCategories(Model model){
		
		Page<Category> pageCategory = categoryService.findAll(0, 10, Direction.DESC, "id");
		
		model.addAttribute("listCategory", pageCategory.getContent());
		model.addAttribute("curPages", pageCategory.getNumber() + 1);
		model.addAttribute("totalPages", pageCategory.getTotalPages());
		model.addAttribute("hasPrev", pageCategory.hasPreviousPage());
		model.addAttribute("hasNext", pageCategory.hasNextPage());
		
		return "categories";
	}
	
	@RequestMapping("/categories/{num}")
	public String getCategoriesPage(Model model, @PathVariable int num){
		
		Page<Category> pageCategory = categoryService.findAll(num-1, 10, Direction.DESC, "id");
		
		model.addAttribute("listCategory", pageCategory.getContent());
		model.addAttribute("curPages", pageCategory.getNumber() + 1);
		model.addAttribute("totalPages", pageCategory.getTotalPages());
		model.addAttribute("hasPrev", pageCategory.hasPreviousPage());
		model.addAttribute("hasNext", pageCategory.hasNextPage());
		
		return "categories";
		
	}
	
	@RequestMapping("/categories/form")
	public String getFormCategory(Model model){
		return "categoriesForm";
	}
	
	@RequestMapping(value = "/categories/form", method = RequestMethod.POST)
	public String doAddCategory(Model model, @ModelAttribute("category") Category category ){
		categoryService.save(category);
		return "redirect:/categories.htm";
	}
	
	@RequestMapping("/categories/form/{id}")
	public String getFormCategoryId(Model model, @PathVariable int id){
		model.addAttribute("category", categoryService.findOne(id));
		return "categoriesForm";
	}
	
	@RequestMapping(value = "/categories/form/{id}", method = RequestMethod.POST)
	public String doUpdateCategory(Model model, @ModelAttribute("category") Category category ){
		categoryService.save(category);
		return "redirect:/categories.htm";
	}
	
	@RequestMapping("/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id){
		categoryService.delete(id);
		return "redirect:/categories.htm";
	}
	
}
