package Control;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IService;
import Model.Contact;

@ManagedBean(name="findContactControl")
@SessionScoped

public class FindContactControl implements Serializable {
	private static final long serialVersionUID = 1L;
	private String criteria;
	private String valeur;
	private ArrayList<Contact> listContact;
	private Contact contact;
	
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	public ArrayList<Contact> searchByMail(String val){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");		
		return service.getContactByEmail(val);
	}
	public ArrayList<Contact> searchByGroup(String val){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");		
		return service.getContactByGroup(val);
	}
	public ArrayList<Contact> searchByNam(String val){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");		
		return service.getContactByLastName(val);
	}
	public ArrayList<Contact> searchByPhone(String val){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");		
		return service.getContactByPhone(val);
	}
	
	
	public String search() {
		System.out.println("cret="+criteria);
		System.out.println("val="+valeur);
		if(criteria.equals("email")){
			System.out.println("par mail");
			setListContact(searchByMail(valeur));
		}
		else
			if(criteria.equals("group")){
				System.out.println("par group");
				setListContact(searchByGroup(valeur));
				
			}else 
				if(criteria.equals("lastName")){
					System.out.println("par nom");
					setListContact(searchByNam(valeur));
					
				}
				else if(criteria.equals("phoneNumber")){
					System.out.println("par phone");
					setListContact(searchByPhone(valeur));					
				}
		
		
		return "find-edit-delete";
	}
	public String deleteContact(Contact contact) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");
		listContact.remove(contact);
		service.deleteContact(contact.getId());	
		return ("find-edit-delete");
	}
	public String load (Contact contact) { 
		setContact(contact);
		return ("update-find-contact");	 
	}
	public String updateContact() {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");
		service.updateContact(contact);
		return ("find-edit-delete");
	}
	
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public ArrayList<Contact> getListContact() {
		return listContact;
	}
	public void setListContact(ArrayList<Contact> listContact) {
		this.listContact = listContact;
	}
	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
}