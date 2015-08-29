package id.nasrul.bms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import id.nasrul.bms.entity.Author;
import id.nasrul.bms.repo.AuthorRepo;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepo authorRepo;
	
	public Page<Author> findAll(int page, int size, Direction direction, String properties){
		return authorRepo.findAll(new PageRequest(page, size, direction, properties));
	}
	
	@Transactional
	public void save(Author author){
		authorRepo.save(author);
	}
	
	public Author findOne(int id){
		return authorRepo.findOne(id);
	}
	
	public void delete(int id){
		authorRepo.delete(id);
	}
	
}
