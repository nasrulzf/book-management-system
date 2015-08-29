package id.nasrul.bms.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.nasrul.bms.entity.Publisher;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {

	Page<Publisher> findAll(Pageable pageable);
	
}
