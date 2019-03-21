package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Absence implements Serializable {
   @Id@GeneratedValue	
   private int idAbsence;
   @Temporal(TemporalType.DATE)
   private Date dateAbsence;
   private String motif;
   private String pieceJustificative;
   private boolean justifie;
   @ManyToOne
   @JoinColumn(name="codeEmploye")
   private Employe employe;
   
   //constructeur sans parametre
   public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}
   //constructeur avec parametre
   public Absence(Date dateAbsence, String motif, String pieceJustificative, boolean justifie) {
		this.dateAbsence = dateAbsence;
		this.motif = motif;
		this.pieceJustificative = pieceJustificative;
		this.justifie = justifie;
	}
	public Date getDateAbsence() {
		return dateAbsence;
	}
	
	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getPieceJustificative() {
		return pieceJustificative;
	}
	public void setPieceJustificative(String pieceJustificative) {
		this.pieceJustificative = pieceJustificative;
	}
	public boolean isJustifie() {
		return justifie;
	}
	public void setJustifie(boolean justifie) {
		this.justifie = justifie;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	} 
}
