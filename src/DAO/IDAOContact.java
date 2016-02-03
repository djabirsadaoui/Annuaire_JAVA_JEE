package DAO;
import java.util.ArrayList;
import java.util.Set;

import Model.*;

import org.springframework.context.ApplicationContext;


public interface IDAOContact {	
	public Contact addContact(Contact contact,String groupcontact);
	public Adresse addAddress(Adresse adr);
	public ContactGroup addGroup(ContactGroup group,Contact contact);
	public Entreprise addContactCompany(Entreprise contact,String groupcontact);
	public int deleteContact(long id );	
	public boolean updateContact(Contact contact);	
	public ArrayList<Contact> getContactByEmail(String email);	
	public ArrayList<Contact> getContactByLastName(String lastname);	
	public ArrayList <Contact> getContactByGroup(String namegroup);
	public ArrayList<Contact> getContactByPhone(String phone);
	public Contact getContactById(long id);
	public ArrayList<Contact> getAllContact();
	
		
		
	
	
}
