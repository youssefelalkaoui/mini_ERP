package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetailsApprovisionnement implements Serializable {
	@Id@GeneratedValue
    private int idDetails;
    private int quantite;
    private double prixAchat;

    @ManyToOne
    @JoinColumn(name="commande_id")
    private CommandeApprovisionnement commandeApprovisionnement;
    
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    
	public DetailsApprovisionnement() {
		super();
	}
	
	public DetailsApprovisionnement( int quantite, double prixAchat, Produit produit,CommandeApprovisionnement commandeApprovisionnement ) {
		this.quantite = quantite;
		this.prixAchat = prixAchat;
		this.commandeApprovisionnement = commandeApprovisionnement;
		this.produit = produit;
	}

	public DetailsApprovisionnement( int quantite, double prixAchat, int produit,
			Long commandeApprovisionnement ) {
		this.quantite = quantite;
		this.prixAchat = prixAchat;
		this.commandeApprovisionnement.setIdApprovisionnement(commandeApprovisionnement);
		this.produit.setIdProduit(produit);
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

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getProduit() {
		return produit.getIdProduit();
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Long getCommandeApprovisionnement() {
		return commandeApprovisionnement.getIdApprovisionnement();
	}

	public void setCommandeApprovisionnement(CommandeApprovisionnement commandeApprovisionnement) {
		this.commandeApprovisionnement = commandeApprovisionnement;
	}
	
	}

