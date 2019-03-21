package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Paiement implements Serializable {
	@Id
	@GeneratedValue
	private int idPaiement;
	private Date datePaiement;
	private Double montant;
	@ManyToOne
	@JoinColumn(name="codeEmploye")
	private Employe employe;
	//constructeur avec parametre
	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}
	//constructeur avec parametre
	public Paiement(Date datePaiement, Double montant) {
		super();
		this.datePaiement = datePaiement;
		this.montant = montant;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
}
