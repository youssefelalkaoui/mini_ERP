package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Conge implements Serializable {
   @Id
   @GeneratedValue
   private Long idConge;
   private Date dateDebut;
   private Date dateFin;
   @ManyToOne
   @JoinColumn(name="id_utilisateur")
   private Employe employe;  
  

   public Conge() {
		super();
	}
	public Conge(Date dateDebut, Date dateFin, Employe employe) {
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.employe = employe;
    }
	public Conge(Date dateDebut, Date dateFin, Long idEmploye) {
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.employe.setIdUtilisateur(idEmploye);;
    }
	public Long getIdConge() {
		return idConge;
	}
	public void setIdConge(Long idConge) {
		this.idConge = idConge;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
}
