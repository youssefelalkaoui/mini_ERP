package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Fournisseur implements Serializable {
	@Id@GeneratedValue
	private int idFournisseur;
	private String nomFournisseur;
	private String adresse;
	private String tele;
	private String email;
	@OneToMany(mappedBy="fournisseur")
	 private List<CommandeApprovisionnement> commandeApprovisionnements = new ArrayList<>();
	//constructeur sans parametre
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	//constructeur avec parametre
	public Fournisseur(String nomFournisseur, String adresse, String tele, String email) {
		this.nomFournisseur = nomFournisseur;
		this.adresse = adresse;
		this.tele = tele;
		this.email = email;
	}
	
	
	
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
