package org.sid.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Mouvement {
	@Id@GeneratedValue
   private int idMouvement;
   private Date dateMouvement;
   private String detailsMouvement;
   private double frais;
   @ManyToOne
	@JoinColumn(name="codeEmploye")
	private Employe  employe;
   //constructeur sans parametre
   public Mouvement() {
		super();
		// TODO Auto-generated constructor stub
	}
   //constructeur avec parametre
	public Mouvement(Date dateMouvement, String detailsMouvement, double frais, Employe employe) {
	this.dateMouvement = dateMouvement;
	this.detailsMouvement = detailsMouvement;
	this.frais = frais;
	this.employe = employe;
    }
	
	public int getIdMouvement() {
		return idMouvement;
	}
	public void setIdMouvement(int idMouvement) {
		this.idMouvement = idMouvement;
	}
	public Date getDateMouvement() {
		return dateMouvement;
	}
	public void setDateMouvement(Date dateMouvement) {
		this.dateMouvement = dateMouvement;
	}
	public String getDetailsMouvement() {
		return detailsMouvement;
	}
	public void setDetailsMouvement(String detailsMouvement) {
		this.detailsMouvement = detailsMouvement;
	}
	public double getFrais() {
		return this.frais;
	}
	public void setFrais(double frais) {
		this.frais = frais;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
    
}
