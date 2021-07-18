package ashu.prac.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import ashu.prac.spring5webapp.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
