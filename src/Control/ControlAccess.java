package Control;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.*;


@ManagedBean(eager= true , name="control")
@ViewScoped

public class ControlAccess implements Serializable {
	
	/**
	 * 
	 */
	
	//login et password du User
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
		
		//Contrôle que les champs sont non-vides
		 if (isMissing(login)||isMissing(password)) {
			 //si les champs ne son pas renseignés, 
			 //JSF forwadera l'execution vers la page missing-login-pass.xhtml
		      return("missing-login-pass");
		
		    } else if (login.equals(password))
		               {
		    	//si le pass est correct, 
				 //JSF forwadera l'execution vers la page welcome-page.xhtml
		      return("welcome-page");
		    } else {
		    	//Sinon, vers la page bad-login.xhtml
		      return("bad-login");
		    }
		
	}
	//Contrôle que les champs sont non-vides
	private boolean isMissing(String value) {
	    return((value == null) || (value.trim().isEmpty()));
	  }
}
