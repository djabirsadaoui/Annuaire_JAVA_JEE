package Control;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;






//@ManagedBean(name="control") 
//@SessionScoped
public class ControlLogin {
	private String login;
	private String password ;
	
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
	
	//Methode Action Controller qui sera référencée dans le formulaire 
	//de la page login.xhtml et appelée par JSF lors de la soumission du formulaire
	public String checkAccess(){
		System.out.println("hollo mr booutaflika");
		//Contrôle que les champs sont non-vides
		 if (isMissing(login)||isMissing(password)) {
			 //si les champs ne son pas renseignés, 
			 //JSF forwadera l'execution vers la page missing-login-pass.xhtml
		      return("login");
		
		    } else if (login.equals(password))
		               {
		    	
		      return("home");
		    } else {
		    	//Sinon, vers la page bad-login.xhtml
		      return("login");
		    }
		
	}
	//Contrôle que les champs sont non-vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }

}
