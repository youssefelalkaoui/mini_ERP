package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CommandeApprovisionnement implements Serializable {
   @Id@GeneratedValue	
   private Long idApprovisionnement;
   private Date dateApprovisionnement;
   private String etatCommande;
   private String etatFacture;
   
   @ManyToOne
   @JoinColumn(name = "id_fournisseur")
   private Fournisseur fournisseur;
      
   @ManyToOne
   @JoinColumn(name="id_utilisateur")
   private Employe employe;
   @OneToMany(mappedBy = "commandeApprovisionnement", cascade = CascadeType.REMOVE)
	 private List<DetailsApprovisionnement> detailsApprovisionnement = new ArrayList<>();
   
   public CommandeApprovisionnement() {
		super();
	}

public CommandeApprovisionnement(Date dateApprovisionnement, String etatCommande,String etatFacture,Employe employe,Fournisseur fournisseur ) {
	super();
	this.dateApprovisionnement = dateApprovisionnement;
	this.etatCommande = etatCommande;
	this.etatFacture = etatFacture;
	this.employe = employe;
	this.fournisseur = fournisseur;
}


public Fournisseur getFournisseur() {
	return fournisseur;
}

public void setFournisseur(Fournisseur fournisseur) {
	this.fournisseur = fournisseur;
}

public Employe getEmploye() {
	return employe;
}

public void setEmploye(Employe employe) {
	this.employe = employe;
}

public Date getDateApprovisionnement() {
	return dateApprovisionnement;
}

public void setDateApprovisionnement(Date dateApprovisionnement) {
	this.dateApprovisionnement = dateApprovisionnement;
}

public String getEtatCommande() {
	return etatCommande;
}

public void setEtatCommande(String etatCommande) {
	this.etatCommande = etatCommande;
}

public String getEtatFacture() {
	return etatFacture;
}

public void setEtatFacture(String etatFacture) {
	this.etatFacture = etatFacture;
}

public Long getIdApprovisionnement() {
	return idApprovisionnement;
}

public void setIdApprovisionnement(Long idApprovisionnement) {
	this.idApprovisionnement = idApprovisionnement;
}


}


