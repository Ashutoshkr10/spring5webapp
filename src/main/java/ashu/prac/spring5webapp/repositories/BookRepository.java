package ashu.prac.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import ashu.prac.spring5webapp.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
