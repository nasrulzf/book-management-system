package id.nasrul.bms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import id.nasrul.bms.entity.Author;
import id.nasrul.bms.entity.Book;
import id.nasrul.bms.entity.Category;
import id.nasrul.bms.entity.Publisher;
import id.nasrul.bms.repo.AuthorRepo;
import id.nasrul.bms.repo.BookRepo;
import id.nasrul.bms.repo.CategoryRepo;
import id.nasrul.bms.repo.PublisherRepo;

@Service
@Transactional
public class InitDbService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private AuthorRepo authorRepo;
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private PublisherRepo publisherRepo;
	
	@PostConstruct
	public void init(){
		
		Category category = new Category();
		category.setName("Pemrograman");
		category.setSeoName(category.getName().toLowerCase().replace(" ", "-"));
		categoryRepo.save(category);
		
		Publisher publisher = new Publisher();
		publisher.setName("ANDI Yogyakarta");
		publisher.setCity("Yogyakarta");
		publisherRepo.save(publisher);
		
		Author author = new Author();
		author.setFirstName("Nasrul Aziz");
		author.setLastName("Gifari");
		authorRepo.save(author);
		
		Author author2 = new Author();
		author2.setFirstName("Abdul");
		author2.setLastName("Kadir");
		authorRepo.save(author2);
		
		Book book = new Book();
		book.setIsbn("24-029348-294");
		book.setPublishedDate(new Date());
		book.setAddedDate(new Date());
		book.setPublisher(publisher);
		book.setCategory(category);
		book.setTitle("Pengenalan Sistem Informasi");
		List<Author> authors = new ArrayList<>();
		authors.add(author2);
		authors.add(author);
		book.setAuthors(authors);
		bookRepo.save(book);
		
	}
	
}
