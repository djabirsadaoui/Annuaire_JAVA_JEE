package Control;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service.*;



@ManagedBean(name="addContactControl")
@RequestScoped
public class AddContactControl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	private String zip;
	private String country;
	private String mobile;
	private String kind;
	private String group;
	private long numSiret;
	
	
	public long getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(long numSiret) {
		this.numSiret = numSiret;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String checkAddContact() {		
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml"); 
		IService service = (IService) context.getBean("beanService");
		service.addContact(firstName, lastName, email, city, country, street, zip, group, mobile, kind);
		return("welcome-page");
	}
	public String checkAddContactCompany() {		
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\djabir\\Desktop\\ma bibliothéque\\Master2_sar\\codel\\workspace\\Myproject\\WebContent\\WEB-INF\\applicationContext.xml"); 
		IService service = (IService) context.getBean("beanService");
		service.addContactCompany(firstName, lastName, email, city, country, street, zip, group, mobile, kind,numSiret);
		return("welcome-page");
	}
	
	
	public void validateEmail(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		String email = (String)value;
		setEmail(email);
		
		if (email != null && email.trim().length() != 0 ) {
	        if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
	        	FacesMessage message = new FacesMessage("Invalid Email");
				throw new ValidatorException(message);
	        }
	    }
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	
	
	
	
	
}