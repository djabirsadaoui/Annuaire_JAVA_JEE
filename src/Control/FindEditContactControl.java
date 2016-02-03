package Control;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.IService;
import Model.Contact;
@ManagedBean(name="findEditContactControl")
@SessionScoped
public class FindEditContactControl implements Serializable {
		 
		private static final long serialVersionUID = 1L;	
		private  ArrayList<Contact> ContactList;
		private Contact contact;
		
		public Contact getContact() {
			return contact;
		}
		public void setContact(Contact contact) {
			this.contact = contact;
		}
		public String deleteContact(Contact contact) {
			ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
			IService service = (IService)context.getBean("beanService");
			ContactList.remove(contact);
			service.deleteContact(contact.getId());	
			return ("find-edit-delete");
		}
		public String load (Contact contact) { 
			setContact(contact);
			return ("update-find-contact");	 
		}
		public String getAllContact() {
			ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
			IService service = (IService)context.getBean("beanService");
			ContactList = service.getAllContact();
			return "";
		}	
		public String updateContact() {
			ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
			IService service = (IService)context.getBean("beanService");
			service.updateContact(contact);
			return ("find-edit-delete");
		}

}
