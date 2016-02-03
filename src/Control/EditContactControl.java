/*package org.lip6.fr.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*annotation qui déclare le Bean à JSF. 
Cela évite de le faire dans le fichier faces-config.xml
il est possible de rajouter l'attribut "name" afin de donner un nom d'alias au Bean. exp @ManagedBean(name="control")
Il sera référencé dans le form login.xhtml à travers ce nom d'alias. 
Autrement, il sera référencé par controlAccess (le c en miniscule)*/


package Control;
 
import java.io.Serializable;
import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IService;
import Model.Contact; 
@ManagedBean(name="editContactControl")
@SessionScoped

public class EditContactControl implements Serializable{
 
	
	private static final long serialVersionUID = 1L;	
	private  ArrayList<Contact> ContactList;
	private Contact contact; 
	private boolean response;
	
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String updateContact() {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma biblioth�que\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");
		
		try {
			response = service.updateContact(contact);
			return ("edit-contact");
		} catch (Exception e) {			
			e.printStackTrace();
			return ("edit-error");
		}
	
	}
	public String getAllContact() {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma biblioth�que\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");
		setContactList(service.getAllContact()); 
		return "edit-contact";
	}
	public String load (Contact contact) { 
		setContact(contact);
		return ("update-contact");
 
	}

	public ArrayList<Contact> getContactList() {
		return ContactList;
	}

	public void setContactList(ArrayList<Contact> contactList) {
		ContactList = contactList;
	}
	
	
	
	
	
}