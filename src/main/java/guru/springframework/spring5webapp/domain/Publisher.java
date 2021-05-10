package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity  
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;  
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	private String name;
	//private Address address;
        private String addressLine1;
        private String city;
        private String state;
        private String postalCode;
	
	@OneToMany
    @JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();
	
	public Publisher() {
	}
	
	public Publisher(String name,String addressLine1,String city,String state,String postalCode) {
		this.name = name;
		//this.address = address;
                this.addressLine1 = addressLine1;
                this.city= city;
                this.state = state;
                this.postalCode = postalCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
        
        public String getAddressLine1() {
		return addressLine1;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
        
        public Set<Book> getBooks(){
            return books;
        }
        
        public void setBooks(Set<Book> books){
            this.books = books;
        }
        
	/*
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	*/
        
	@Override
	public String toString() { // to show the property of an object in String JSON format
		return "Publisher{"
				+ "id= " + id
				+ ",name= " + name + '\''
				+ ",address Line 1= " + addressLine1 + '\''
				+ ",city= " + city + '\''
				+ ",state= "+ state + '\''
				+ ",postal code= " + postalCode + '\''
				+ '}';
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		
		Publisher publisher = (Publisher) o;
		
		return id != null ? id.equals(publisher.id) : publisher.id == null;
	}
	
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() :0;
	}
}
