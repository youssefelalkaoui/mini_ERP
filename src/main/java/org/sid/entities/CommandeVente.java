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
public class CommandeVente implements Serializable {
   @Id@GeneratedValue	
   private Long idVente;
   private Date dateCommande;
   private String etatCommande;
   private String etatFacture;
   private String nomClient;
   private String prenomClient;
   private String tel;
   private String adresseLivraison;
      
   @ManyToOne
   @JoinColumn(name="id_utilisateur")
   private Employe employe;
   @OneToMany(mappedBy = "commandeVente", cascade = CascadeType.REMOVE)
	 private List<DetailsVente> detailsVentes = new ArrayList<>();
   
   public CommandeVente() {
		super();
	}

public CommandeVente(Date dateCommande, String etatCommande, String etatFacture, String nomClient, String prenomClient,
		String tel, String adresseLivraison,Employe employe) {
	super();
	this.dateCommande = dateCommande;
	this.etatCommande = etatCommande;
	this.etatFacture = etatFacture;
	this.nomClient = nomClient;
	this.prenomClient = prenomClient;
	this.tel = tel;
	this.adresseLivraison = adresseLivraison;
	this.employe = employe;
}

public Long getIdVente() {
	return idVente;
}

public void setIdVente(Long idVente) {
	this.idVente = idVente;
}

public Date getDateCommande() {
	return dateCommande;
}

public void setDateCommande(Date dateCommande) {
	this.dateCommande = dateCommande;
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

public String getNomClient() {
	return nomClient;
}

public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}

public String getPrenomClient() {
	return prenomClient;
}

public void setPrenomClient(String prenomClient) {
	this.prenomClient = prenomClient;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getAdresseLivraison() {
	return adresseLivraison;
}

public void setAdresseLivraison(String adresseLivraison) {
	this.adresseLivraison = adresseLivraison;
}

public Employe getEmploye() {
	return employe;
}

public void setEmploye(Employe employe) {
	this.employe = employe;
}




}


