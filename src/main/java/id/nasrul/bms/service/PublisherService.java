package id.nasrul.bms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import id.nasrul.bms.entity.Publisher;
import id.nasrul.bms.repo.PublisherRepo;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepo publisherRepo;
	
	public Page<Publisher> findAll(int page, int size, Direction direction, String properties){
		return publisherRepo.findAll(new PageRequest(page, size, direction, properties));
	}
	
	public Publisher findOne(int id){
		return publisherRepo.findOne(id);
	}
	
	@Transactional
	public void save(Publisher publisher){
		publisherRepo.save(publisher);
	}
	
	@Transactional
	public void delete(int id){
		publisherRepo.delete(id);
	}
	
}
