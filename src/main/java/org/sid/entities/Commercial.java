package org.sid.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("commercial")
public class Commercial extends Employe {
	    
	public Commercial() {
		super();
	}
	public Commercial(String nom, String prenom, Date dateNaissance, String login, String password, String email,
			String avatar, double salaire, String typeEmploye) {
		super(nom, prenom, dateNaissance, login, password, email, avatar, salaire, typeEmploye);
	}


	 
	
}
