package service;






import java.util.ArrayList;
import java.util.Set;

import javax.faces.bean.ManagedProperty;

import org.springframework.context.ApplicationContext;














import org.springframework.context.support.FileSystemXmlApplicationContext;

import Model.Contact;
import Model.ContactGroup;
import Model.Entreprise;
import DAO.*;
import Model.PhoneNumber;


public class ServiceImp implements IService {
//	@ManagedProperty(value="#{DaoContact}")
//	private IDAOContact dao;
//	@ManagedProperty(value="#{beanContact}")
//	private Contact contact ;
//	@ManagedProperty(value="#{beanPhone}")
//	private PhoneNumber phone;
	
	public String addContact(String Firstname, String Lastname,String mail,String city,String country, String street,String Zip,String group,String number,String type) {		
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");	
     	Contact contact=(Contact)context.getBean("beanContact");
     	PhoneNumber phone = (PhoneNumber)context.getBean("beanPhone");
     	IDAOContact dao = (IDAOContact)context.getBean("DaoContact");
     	contact.getAddress().setCity(city);
     	contact.getAddress().setCountry(country);
     	contact.getAddress().setStreet(street);
     	contact.getAddress().setZip(Zip);     	
     	phone.setPhoneKind(type);
     	phone.setPhoneNumber(number);			
     	contact.addNumber(phone); 	
     	contact.setNom(Firstname);
     	contact.setPrenom(Lastname);
     	contact.setMail(mail);     	
	    dao.addContact(contact,group);		   
	    return "";
		
	}
	public String addContactCompany(String Firstname, String Lastname,String mail,String city,String country, String street,String Zip,String group,String number,String type,long numsiret){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");	
     	Entreprise contact=(Entreprise)context.getBean("beanEntreprise");
     	PhoneNumber phone = (PhoneNumber)context.getBean("beanPhone");
     	IDAOContact dao = (IDAOContact)context.getBean("DaoContact");
     	
     	contact.getAddress().setCity(city);
     	contact.getAddress().setCountry(country);
     	contact.getAddress().setStreet(street);
     	contact.getAddress().setZip(Zip);  
     	
     	phone.setPhoneKind(type);
     	phone.setPhoneNumber(number);			
     	contact.addNumber(phone);
     	
     	contact.setNumSiret(numsiret);
     	contact.setNom(Firstname);
     	contact.setPrenom(Lastname);
     	contact.setMail(mail);
     	
	    dao.addContactCompany(contact, group);		   
	    return "";
	 
	}
	public ArrayList<Contact> getContactByPhone(String phone){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		
		IDAOContact dao = (IDAOContact)context.getBean("DaoContact");		
		return dao.getContactByPhone(phone);
	}
	public int deleteContact(long id){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IDAOContact dao = (IDAOContact)context.getBean("DaoContact");		
		return dao.deleteContact(id);
	}
	public ArrayList<Contact> getContactByLastName(String lastname){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IDAOContact dao = (IDAOContact)context.getBean("DaoContact");		
		return dao.getContactByLastName(lastname);	
		
	}
	public ArrayList<Contact> getContactByEmail(String email){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IDAOContact dao = (IDAOContact)context.getBean("DaoContact");		
		return dao.getContactByEmail(email);
	}
	public ArrayList <Contact> getContactByGroup(String namegroup){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IDAOContact dao = (IDAOContact)context.getBean("DaoContact");
		return dao.getContactByGroup(namegroup);
	}
	public boolean updateContact(Contact contact){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IDAOContact dao = (IDAOContact)context.getBean("DaoContact");		
		return dao.updateContact(contact);
	}	
	public Contact getContactById(long id){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IDAOContact dao = (IDAOContact)context.getBean("DaoContact");
		return dao.getContactById(id);
	}
	public ArrayList<Contact> getAllContact(){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IDAOContact dao = (IDAOContact)context.getBean("DaoContact");
		return dao.getAllContact();
	}
	

}
