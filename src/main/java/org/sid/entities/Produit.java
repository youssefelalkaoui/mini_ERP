package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Produit implements Serializable {
	@Id@GeneratedValue
    private int idProduit;
    private String nomProduit;
    private double prix;
    private String photo;
    private int quantite;
    @ManyToOne
    @JoinColumn(name="codeCategorie")
    private Categorie categorie;

    @OneToMany(mappedBy="produit")
	 private List<DetailsApprovisionnement> detailsApprovisionnement = new ArrayList<>();
  
        public Produit() {
		super();
	}
    //constructeur avec parametre
    public Produit(String nomProduit, double prix, String photo, int quantite) {
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.photo = photo;
		this.quantite = quantite;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

    
	
	
       
}
