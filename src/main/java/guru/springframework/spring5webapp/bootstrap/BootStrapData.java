package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
//import guru.springframework.spring5webapp.domain.Address;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository ar;
	private final BookRepository br;
	private final PublisherRepository pr;
	
	public  BootStrapData(AuthorRepository ar, BookRepository br, PublisherRepository pr) {
		this.ar = ar;
		this.br = br;
		this.pr = pr;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Author suyash = new Author("Suyash","Verma");
		Book sbme = new Book("Spring Boot Made Easy","1429587");
		
		Publisher chandra = new Publisher("chandra Publishing house","House Number 114 Vibhav Khand","Lucknow","Uttar Pradesh","226010");
		
		// add book to author and author to book
		suyash.getBooks().add(sbme);
		sbme.getAuthors().add(suyash);
		sbme.setPublisher(chandra);
        chandra.getBooks().add(sbme);
		
		// save in repositories
		ar.save(suyash);
		br.save(sbme);
		pr.save(chandra);
		
		System.out.println("Printing via BootStrap class - ");
		//System.out.println(suyash.toString());
		//System.out.println(sbme.toString());
		
		System.out.println("Author Repository count - " +ar.count());
		System.out.println("Book Repository count - " +br.count());
		System.out.println("Publisher Repository count - " +pr.count());
		
	}

}
