package id.nasrul.bms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import id.nasrul.bms.entity.Author;
import id.nasrul.bms.entity.Book;
import id.nasrul.bms.repo.AuthorRepo;
import id.nasrul.bms.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private AuthorRepo authorRepo;
	
	public Page<Book> findAll(int page, int size, Direction direction, String properties){
		
		Page<Book> pageBook = bookRepo.findAll(new PageRequest(page, size, direction, properties));
		
		for(Book book : pageBook.getContent()){
			List<Author> listAuthor =  authorRepo.findByBooks(book);
			book.setAuthors(listAuthor);
		}
		
		return pageBook;
	}
	
	public Book findOne(String isbn){
		return bookRepo.findOne(isbn);
	}
	
	@Transactional
	public void save(Book book){
		bookRepo.save(book);
	}
	
	@Transactional
	public void delete(String isbn){
		bookRepo.delete(isbn);
	}
	
}
