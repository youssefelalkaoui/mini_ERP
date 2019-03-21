package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_EMPLOYE")
public  class Employe implements Serializable {
	@Id @GeneratedValue
	private Long idUtilisateur;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String login;
    private String password;
    private String email;
    private String avatar;
    private double salaire;
    
    @Column(name="TYPE_EMPLOYE", nullable=false, updatable=false, insertable=false)
    private String typeEmploye;
    @OneToMany(mappedBy="employe")
    private List<CommandeApprovisionnement> commandeApprovisionnements = new ArrayList<>();
    
    @OneToMany(mappedBy = "employe")
    private List<CommandeVente> commandeVentes = new ArrayList<>();
    
    @OneToMany(mappedBy="employe")
	 private List<Recrutement> recrutements = new ArrayList<>();
	 @OneToMany(mappedBy="employe")
	 private List<Mouvement> mouvements = new ArrayList<>();
    
    @OneToMany(mappedBy="employe")
    private List<Conge> conges = new ArrayList<>();
    
    @OneToMany(mappedBy="employe")
    private List<Paiement> paiements = new ArrayList<>();

    @OneToMany(mappedBy="employe")
    private List<Absence> absences = new ArrayList<>();

    public Employe() {
		super();
	}
    public Employe(String nom, String prenom, Date dateNaissance, String login, String password, String email,
			String avatar, double salaire, String typeEmploye) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.login = login;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.salaire = salaire;
		this.typeEmploye = typeEmploye;
	}
    

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public void setTypeEmploye(String type) {
		this.typeEmploye = type;
	}
	public String getTypeEmploye() {
		return typeEmploye;
	}
	
		
}
