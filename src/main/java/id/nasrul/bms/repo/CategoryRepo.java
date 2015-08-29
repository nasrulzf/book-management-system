package id.nasrul.bms.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.nasrul.bms.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Page<Category> findAll(Pageable pageable);
	
}
