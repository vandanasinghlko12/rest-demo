package bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import bootrestbook.dao.BookRepository;
import bootrestbook.entities.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookrepository;
	
	/*private static List<Book> list = new ArrayList<>();
	static {
		
		list.add(new Book(1,"abc","regty"));
		list.add(new Book(2,"def","fghvg"));
		list.add(new Book(3,"ghi","hbbkj"));
		
	}*/
	
	public List<Book> getAllBooks(){
		
	List<Book> list=	(List<Book>) this.bookrepository.findAll();
		return list;
	}
	
    public Book getBookById(int id) {
    	Book book=null;
    	try {
  //  book=	list.stream().filter(e->e.getId()==id).findFirst().get();
    	book	=this.bookrepository.findById(id);
    	}
    	catch(Exception e) {
    		
    	e.printStackTrace();	
    	}
    	return book;
    }
    
    public Book addBook(Book b) {
    //	list.add(b);
    	
    b	=this.bookrepository.save(b);
    	return b;
    }
    
    public void deleteBook(int bid) {
    	
    	// list=list.stream().filter(f->f.getId()!=bid).collect(Collectors.toList());
    	this.bookrepository.deleteAll();
    	
    }
    
    public void updateBook(Book book ,int id){
    	
  /*  list=	list.stream().map(b->{
    		if(b.getId()==id) {
    			
    			b.setTitle("fdgh");
    			b.setAuthor("fsdrt");
    		}
    		return b;
    		
    	}).collect(Collectors.toList());*/
    	
    	book.setId(id);
    	
    this.bookrepository.save(book);
    	
    	
    }

}
