package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Goups")
public class ContactGroup {
	private Set <Contact> contacts = new HashSet<Contact>();
	private long grouId;
	private String groupName;
	
	
	public ContactGroup(){		
		
	}
	
	@ManyToMany
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public long getGrouId() {
		return grouId;
	}
	public void setGrouId(long grouId) {
		this.grouId = grouId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	public void addContact(Contact contact){
		contact.getBooks().add(this);
		getContacts().add(contact);
	}
	

}
