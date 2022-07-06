package bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import bootrestbook.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
	
	public Book findById(int id);

	
}
