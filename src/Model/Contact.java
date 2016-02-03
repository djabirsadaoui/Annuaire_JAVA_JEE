package Model;
import java.util.Set;
public class Contact  { 
	protected String nom;
	protected String prenom;
	protected String mail;
	protected long id;
	protected Adresse address;
	protected Set <ContactGroup> books;
	protected Set <PhoneNumber>  profiles;	
	protected int verssion;
    
	
	public int getVerssion() {
		return verssion;
	}


	public void setVerssion(int verssion) {
		this.verssion = verssion;
	}


	public Contact(){		
	}
	
	
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Adresse getAddress() {
		return address;
	}
	public void setAddress(Adresse address) {
		this.address = address;
	}


	 public void addNumber(PhoneNumber number){
		 number.setContact(this);
		  getProfiles().removeAll(profiles);
		  getProfiles().add(number);
	 }

	

	public Set<PhoneNumber> getProfiles() {
		return profiles;
	}


	public void setProfiles(Set<PhoneNumber> profiles) {
		this.profiles = profiles;
	}

	
	public Set <ContactGroup> getBooks() {
		return books;
	}


	public void setBooks(Set <ContactGroup> books) {
		
		this.books = books;
	}
	
	public void addGroup(ContactGroup groupe){
		//getBooks().removeAll(books);
		getBooks().removeAll(books);
		groupe.getContacts().add(this);
		getBooks().add(groupe);
	
	}
}
