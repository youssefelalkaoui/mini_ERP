package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@DiscriminatorValue("admin")
public class Administrateur extends Employe {
	
    public Administrateur() {
		super();
	}
    public Administrateur(String nom, String prenom, Date dateNaissance, String login, String password, String email,
			String avatar, double salaire, String typeEmploye) {
		super(nom, prenom, dateNaissance, login, password, email, avatar, salaire, typeEmploye);

	}
   
}
