package org.lib.LibraryManagement.repository;

import java.util.List;
import org.lib.LibraryManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
//	@Query("select b from Book b where b.id=?1 and b.name=?2")
//	Book findByIdAndName(int id,String name);
//	
//	List<Book> findByName(String name);
	
	@Query("select b from Book b where b.genre=?1")
	List<Book> findByGenere(String genre);

}
