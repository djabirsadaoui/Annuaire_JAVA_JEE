
package Control;
 
import java.io.Serializable;
import java.util.ArrayList;




import javax.faces.bean.ManagedBean;



import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IService;
import Model.Contact; 
@ManagedBean(name="deleteContactControl")
@SessionScoped

public class DeleteContactControl implements Serializable{
 
	private static final long serialVersionUID = 1L;	
	private  ArrayList<Contact> ContactList;
	
	public String deleteContact(Contact contact) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");
		ContactList.remove(contact);
		service.deleteContact(contact.getId());			
		return ("remove-contact");
	}
	public String getAllContact() {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		IService service = (IService)context.getBean("beanService");
		setContactList(service.getAllContact()); 
		return "remove-contact";
	}
	public ArrayList<Contact> getContactList() {
		return ContactList;
	}
	public void setContactList(ArrayList<Contact> contactList) {
		ContactList = contactList;
	}	
	
	
	
	
}