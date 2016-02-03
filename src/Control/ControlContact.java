package Control;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;


//@ManagedBean(name="contact")
//@SessionScoped
public class ControlContact {
	protected String nom;
	protected String prenom;
	protected String mail;
	private String street;
	private String city;
	private String zip;
	private String country ;
	private String phoneKind;
	private String phoneNumber;
	private String groupName;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public String getPhoneKind() {
		return phoneKind;
	}
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String checkAccess(){		
		//Contrôle que les champs sont non-vides
		 if (isMissing(nom)||isMissing(prenom)||isMissing(mail)||isMissing(country)||isMissing(city)||isMissing(groupName)||isMissing(phoneKind)||isMissing(phoneNumber)||isMissing(street)||isMissing(zip)) {
			 //si les champs ne son pas renseignés, 
			 //JSF forwadera l'execution vers la page missing-login-pass.xhtml
		      return("AddCont");
		
		    } 
		     else {
		      System.out.println("OK");
		      return("home");
		    }
		
	}
	//Contrôle que les champs sont non-vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }


}
