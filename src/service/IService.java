package service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.context.ApplicationContext;

import Model.Contact;
import Model.Entreprise;





public interface IService {
	public String addContact(String Firstname, String Lastname,String mail,String city,String country, String street,String Zip,String group,String number,String type);
	public int deleteContact(long id );	
	public String addContactCompany(String Firstname, String Lastname,String mail,String city,String country, String street,String Zip,String group,String number,String type,long numsiret);
	public ArrayList<Contact> getContactByLastName(String lastname);
	public ArrayList<Contact> getContactByEmail(String email);
	public ArrayList <Contact> getContactByGroup(String namegroup);
	public boolean updateContact(Contact contact);	
	public Contact getContactById(long id);
	public ArrayList<Contact> getAllContact();
	public ArrayList<Contact> getContactByPhone(String phone);
		

}
