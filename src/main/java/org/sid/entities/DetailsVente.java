package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetailsVente implements Serializable {
	@Id@GeneratedValue
    private int idDetails;
    private int quantite;
    private double prixVente;

    @ManyToOne
    @JoinColumn(name="commande_id")
    private CommandeVente commandeVente;
    
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    
	public DetailsVente() {
		super();
	}
	
	public DetailsVente( int quantite, double prixVente, Produit produit,CommandeVente commandeVente ) {
		this.quantite = quantite;
		this.prixVente = prixVente;
		this.commandeVente = commandeVente;
		this.produit = produit;
	}

	public int getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(int idDetails) {
		this.idDetails = idDetails;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	public int getProduit() {
		return produit.getIdProduit();
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public CommandeVente getCommandeVente() {
		return commandeVente;
	}

	public void setCommandeVente(CommandeVente commandeVente) {
		this.commandeVente = commandeVente;
	}
	
	}

