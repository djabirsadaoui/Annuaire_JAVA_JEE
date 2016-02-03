package Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Entreprise")
public class Entreprise extends Contact {
	private long numSiret;
	public Entreprise(){
		super();	
	}
	
	
	public long getNumSiret() {
		return numSiret;
	}

	@Override
	public void addNumber(PhoneNumber number) {
		 number.setContact(this);
		  getProfiles().removeAll(profiles);
		  getProfiles().add(number);
		 
	}
	
	
	
	
	public void setNumSiret(long numSiret) {
		this.numSiret = numSiret;
	}

}
