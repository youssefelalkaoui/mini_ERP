package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recrutement implements Serializable {
	@Id@GeneratedValue
	private int idRecrutement;
	private Date dateRecrutement;
	private String typeContract;
	@ManyToOne
	@JoinColumn(name="codeEmploye")
	private Employe  employe;
	//constructeur sans parametre
	public Recrutement() {
	super();
	// TODO Auto-generated constructor stub
    }
	//constructeru avec parametre

	public Recrutement(Date dateRecrutement, String typeContract,Employe employe) {
		this.dateRecrutement = dateRecrutement;
		this.typeContract = typeContract;
		this.employe = employe;
	}
	
	public int getIdRecrutement() {
		return idRecrutement;
	}

	public void setIdRecrutement(int idRecrutement) {
		this.idRecrutement = idRecrutement;
	}

	public Date getDateRecrutement() {
		return dateRecrutement;
	}
	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
	public String getTypeContract() {
		return typeContract;
	}
	public void setTypeContract(String typeContract) {
		this.typeContract = typeContract;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}
