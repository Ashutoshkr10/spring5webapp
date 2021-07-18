package ashu.prac.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ashu.prac.spring5webapp.models.Author;
import ashu.prac.spring5webapp.models.Book;
import ashu.prac.spring5webapp.models.Publisher;
import ashu.prac.spring5webapp.repositories.AuthorRepository;
import ashu.prac.spring5webapp.repositories.BookRepository;
import ashu.prac.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		initData();
	}

	private void initData() {
		
		Publisher harpC = new Publisher("Harper Collins","Harpers address");
		Publisher worx = new Publisher("Worx","Worx's address");
		
		publisherRepository.save(harpC);
		publisherRepository.save(worx);
		
		// eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harpC);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Jhonson");
		Book noEJB = new Book("J2EE development without EJB", "2344", worx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}

	

}
