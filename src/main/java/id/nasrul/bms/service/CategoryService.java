package id.nasrul.bms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import id.nasrul.bms.entity.Category;
import id.nasrul.bms.repo.CategoryRepo;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Page<Category> findAll(int page, int size, Direction direction, String properties){
		return categoryRepo.findAll(new PageRequest(page, size, direction, properties));
	}
	
	@Transactional
	public void save(Category category){
		category.setSeoName(category.getName().toLowerCase().replace(" ", "-"));
		categoryRepo.save(category);
	}
	
	public Category findOne(int id){
		return categoryRepo.findOne(id);
	}
	
	@Transactional
	public void delete(int id){
		categoryRepo.delete(id);
	}
	
}
