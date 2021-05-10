package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity  //javax.persistence.Entity : JPA uses a database table for every entity
public class Author {
	/*
	 * By default, the table name corresponds to the class name. 
	 * You can change this with the addition to the annotation @Table(name="NEWTABLENAME").
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //JPA allows to auto-generate the primary key in the database via the @GeneratedValue annotation
	private Long id;  //All entity classes must define a primary key
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	private String firstname;
	private String lastname;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();
	
	public Author() {
		/* No args constructor for JPA
		 * must have a non-arg constructor and or not allowed to be final. 
		 * Keys can be a single field or a combination of fields
		 * */
	}
	
	public Author(String firstname,String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public String getFistname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Set<Book> getBooks(){
		return books;
	}
	
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() { // to show the property of an object in String JSON format
		return "Author{"
				+ "id= " + id
				+ ",firstname= " + firstname + '\''
				+ ",lastname= " + lastname
				+ '}';
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		
		Author author = (Author) o;
		
		return id != null ? id.equals(author.id) : author.id == null;
	}
	
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() :0;
	}
}
