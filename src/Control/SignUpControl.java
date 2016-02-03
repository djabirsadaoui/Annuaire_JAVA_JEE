package Control;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
/*annotation qui déclare le Bean à JSF. 
Cela évite de le faire dans le fichier faces-config.xml
il est possible de rajouter l'attribut "name" afin de donner un nom d'alias au Bean. exp @ManagedBean(name="control")
Il sera référencé dans le form login.xhtml à travers ce nom d'alias. 
Autrement, il sera référencé par controlAccess (le c en miniscule)*/

@ManagedBean(name="signupControl")
@SessionScoped

public class SignUpControl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//login et password du User
	private String login;
	private String password;
	private String passwordConfirmation;
	private String firstName;
	private String lastName;
	private String group;
	private String email;
	private String street;
	private String city;
	private String zip;
	private String country;
	private String mobile;
	private String home;
	private String office;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	
	public String getHome() {
		return home;
	}
	
	public void setHome(String home) {
		this.home = home;
	}
	
	public String getOffice() {
		return office;
	}
	
	public void setOffice(String office) {
		this.office = office;
	}

	public String checkSignUp() {
		/*if (password.equals(passwordConfirmation)) {
			return("welcome-page");
		} else {
		    return("bad-signup");
		}*/
		
		return("welcome-page");
	}
	
	public void validatePassword(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String password = (String)value;
		setPassword(password);
		
		if (password != null && password.trim().length() != 0) {
	        if (password.trim().length() < 3) {
	        	FacesMessage message = new FacesMessage("Password Must Be At Least 3 Characters Long");
				throw new ValidatorException(message);
	        }
	    }
	}
	
	public void validateConfirmation(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String confirmation = (String)value;
		
		System.out.println("Password: " + getPassword());
		System.out.println("Confirmation: " + confirmation);
		
		if (password != null && password.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
	        if (!password.equals(confirmation)) {
	        	FacesMessage message = new FacesMessage("Password Mismatch");
				throw new ValidatorException(message);
	        }
	    }
	}
	
	public void validateEmail(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		String email = (String)value;
		
		if (email != null && email.trim().length() != 0 ) {
	        if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
	        	FacesMessage message = new FacesMessage("Invalid Email");
				throw new ValidatorException(message);
	        }
	    }
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}