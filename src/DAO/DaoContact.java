package DAO;
import java.util.ArrayList;

import Model.*;

import java.util.List;
import java.util.Set;

import org.hibernate.StaleObjectStateException;
import org.springframework.orm.hibernate3.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class DaoContact  implements IDAOContact {
	
	private HibernateTemplate hibernateTemplate;
	private ArrayList<Contact> contacts;
	
	public void setHibernateTemplate(HibernateTemplate template){
    	this.hibernateTemplate = template;
	}	
	
	
		
	public Contact addContact(Contact contact,String groupcontact){	
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		try{			
			ContactGroup group = getGroupByName(groupcontact);		
		     if( group == null){//s le groupe n'existe pas avant 
		    	 group =(ContactGroup) context.getBean("beanGroup");
		    	 group.setGroupName(groupcontact);
		     }		     	
				contact.addGroup(group);	
				hibernateTemplate.save(contact); 		
			}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return contact;
	}
	
	public Entreprise addContactCompany(Entreprise contact,String groupcontact){		
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml");
		try{			
			ContactGroup group = getGroupByName(groupcontact);		
		     if( group == null){//s le groupe n'existe pas avant 
		    	 group =(ContactGroup) context.getBean("beanGroup");
		    	 group.setGroupName(groupcontact);
		     }		     	
				contact.addGroup(group);	
				hibernateTemplate.save(contact); 		
			}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return contact;
	}
		
	public Adresse addAddress(Adresse adr){				
		try{			
			hibernateTemplate.save(adr);			
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		return adr;
	}
		public ContactGroup addGroup(ContactGroup group,Contact contact){		
		try{			
			hibernateTemplate.save(group);			
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		return group;
	}
		
		public int deleteContact(long id ){
		int succes=0;	
		try{		
			Contact contact = hibernateTemplate.load(Contact.class, id);	
			if(contact!=null){
				succes=1;		
				Set<ContactGroup> list_group= contact.getBooks();
				for (ContactGroup gr : list_group) {// pour chaque groupe dont le contact appartient supprimer contacte de ces groupes
					gr.getContacts().remove(contact);
					if(gr.getContacts().size()==0)// si ce groupe ne contient aucun contact supprime le
						hibernateTemplate.delete(gr);
				}
				contact.getBooks().clear();
				Set<PhoneNumber> list_phone= contact.getProfiles();				
				hibernateTemplate.delete(contact);		
			}
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}	
		return succes;
	}

	
	
	public boolean updateContact(Contact contact){
		hibernateTemplate.update(contact);		
		return true;
			
	}
						/* requête parametrés*/
	public ArrayList<Contact> getContactByLastName(String lastname){	
		String query ="from Contact  contact where contact.nom =:nom";
		ArrayList<Contact> contacts = (ArrayList<Contact>) hibernateTemplate.findByNamedParam(query,"nom",lastname);			
		return contacts;		
	}
	 
	public ArrayList <Contact> getContactByGroup(String namegroup){
		ArrayList<ContactGroup> group;
		ArrayList<Contact >contacts = new ArrayList<Contact>();		
		String query =" from ContactGroup group where group.groupName=:name";			
		group =  (ArrayList<ContactGroup>)hibernateTemplate.findByNamedParam(query, "name", namegroup);	
		for (ContactGroup contactGroup : group) {			
			for (Contact contact : contactGroup.getContacts()) {				
				contacts.add(contact);		
			}			
		}
		
		return contacts; 
		}
	
	public ArrayList <Contact> getContactByPhone(String phoneNumber){
		ArrayList<PhoneNumber> phones;
		ArrayList<Contact >contacts = new ArrayList<Contact>();	
		
		String query =" from PhoneNumber phone where phone.phoneNumber=:number";			
		phones =  (ArrayList<PhoneNumber>)hibernateTemplate.findByNamedParam(query, "number", phoneNumber);	
		for (PhoneNumber ph : phones) {								
			contacts.add(ph.getContact());					
		}		
		return contacts; 
		}
	
	public ArrayList<Contact> getContactByEmail(String email){
		ArrayList<Contact> contacts;
		String query ="from Contact  contact where contact.mail =:mail";
		contacts =  (ArrayList<Contact>) hibernateTemplate.findByNamedParam(query, "mail", email);		
		return contacts;
	}
				/*requête simple*/
	
	public ArrayList<Contact> getAllContact(){
		ArrayList<Contact> contacts;
		String query ="from Contact";
		contacts =  (ArrayList<Contact>) hibernateTemplate.find(query);
		return contacts;
	}
	public ContactGroup getGroupByName(String groupName){
		List<ContactGroup> listGroup = (List<ContactGroup>)hibernateTemplate.find("from ContactGroup");			
			for (ContactGroup cg : listGroup) {
				if(groupName.equals(cg.getGroupName()))
					return cg;
			}
			return null;
		}
	public Contact getContactById(long id){
		return hibernateTemplate.load(Contact.class, id);
	}


}

	