package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Categorie implements Serializable {
   @Id@GeneratedValue	
   private int idCategorie;
   private String libelle;
   @OneToMany(mappedBy="categorie")
	private List<Produit> produits = new ArrayList<>();

   //constructeur sans parametre
   public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
   //constructeur avec parametre
   public Categorie(String libelle) {
		this.libelle = libelle;
   }
   
	public int getIdCategorie() {
	return idCategorie;
}
public void setIdCategorie(int idCategorie) {
	this.idCategorie = idCategorie;
}
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
   
}
