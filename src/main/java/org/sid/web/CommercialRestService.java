package org.sid.web;

import java.util.List;


import org.sid.dao.CommandeApprovisionnementRepository;
import org.sid.dao.CommandeVenteRepository;
import org.sid.dao.CommercialRepository;
import org.sid.dao.DetailsApprovisionnementRepository;
import org.sid.dao.DetailsVenteRepository;
import org.sid.dao.EmployeRepository;
import org.sid.dao.FournisseurRepository;
import org.sid.dao.ProduitRepository;
import org.sid.entities.CommandeApprovisionnement;
import org.sid.entities.CommandeVente;
import org.sid.entities.Commercial;
import org.sid.entities.Conge;
import org.sid.entities.DetailsApprovisionnement;
import org.sid.entities.DetailsVente;
import org.sid.entities.Employe;
import org.sid.entities.Fournisseur;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommercialRestService {
	@Autowired
    private CommandeApprovisionnementRepository caRepository;
   @Autowired
    private CommandeVenteRepository venteRepository;
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private DetailsApprovisionnementRepository detailsApprovisionnement;
	@Autowired
	private DetailsVenteRepository detailsVente;
	@Autowired
	private CommercialRepository commercialRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
@RequestMapping(value="/chercherAchats", method=RequestMethod.GET)
public Page<CommandeApprovisionnement> chercher(
		@RequestParam(name="mc", defaultValue="") String mc,
		@RequestParam(name="page", defaultValue="0") int page,
		@RequestParam(name="size", defaultValue="5") int size) {
	return caRepository.chercher("%"+mc+"%", new PageRequest(page, size));
}

@RequestMapping(value="/achat/{id}", method=RequestMethod.GET)
public CommandeApprovisionnement getAchat(@PathVariable Long id){
	return caRepository.getOne(id);
}	

@RequestMapping(value="/produits", method=RequestMethod.GET)
public List<Produit> getProduits(){
	return produitRepository.findAll();
}
@RequestMapping(value="/fournisseurs", method=RequestMethod.GET)
public List<Fournisseur> getFournisseurs(){
	return fournisseurRepository.findAll();
}

@RequestMapping(value="/addDetailsAchat/{idAchat}/{idProduit}", method=RequestMethod.POST)
public DetailsApprovisionnement saveDetailsAchat(@PathVariable Long idAchat,@PathVariable Integer idProduit, @RequestBody DetailsApprovisionnement d){		
	CommandeApprovisionnement cmapp = new CommandeApprovisionnement();
	cmapp = caRepository.getOne(idAchat);
	Produit p = new Produit();
    p = produitRepository.getOne(idProduit);
	DetailsApprovisionnement da = new DetailsApprovisionnement(d.getQuantite(), d.getPrixAchat(), p, cmapp);
return detailsApprovisionnement.save(da);
}
@RequestMapping(value="/detailsAchat", method=RequestMethod.GET)
public List<DetailsApprovisionnement> getAllDetails(@RequestParam(name="id") Long id){
	return detailsApprovisionnement.getAllDetails(id);
}

@RequestMapping(value="/accept-achat", method=RequestMethod.GET)
public boolean acceptAchat(@RequestParam(name="id") Long id){
	//return detailsApprovisionnement.acceptAchat(id);
	CommandeApprovisionnement ca = new CommandeApprovisionnement();
	ca = caRepository.getOne(id);
	ca.setEtatCommande("validée");
	caRepository.save(ca);
	return true;
}

@RequestMapping(value="/add_achat/{idUser}/{idFournisseur}", method=RequestMethod.POST)
public CommandeApprovisionnement saveAchat(@PathVariable Long idUser,@PathVariable Integer idFournisseur, @RequestBody CommandeApprovisionnement c){
	
	Employe emp = new Employe();
	emp = employeRepository.getOne(idUser);
	
Fournisseur f = new Fournisseur();
f = fournisseurRepository.getOne(idFournisseur);
CommandeApprovisionnement cmd = new CommandeApprovisionnement(c.getDateApprovisionnement(), c.getEtatCommande(), c.getEtatFacture(), emp, f);
return caRepository.save(cmd);
}
@RequestMapping(value="/deleteAchat/{id}", method=RequestMethod.DELETE)
public boolean supprimer(@PathVariable Long id){
	caRepository.deleteById(id);
	 return true;
}

// Ventes services
@RequestMapping(value="/chercherVentes", method=RequestMethod.GET)
public Page<CommandeVente> chercheVentes(
		@RequestParam(name="mc", defaultValue="") String mc,
		@RequestParam(name="page", defaultValue="0") int page,
		@RequestParam(name="size", defaultValue="5") int size) {
	return venteRepository.chercherVente("%"+mc+"%", new PageRequest(page, size));
}

@RequestMapping(value="/vente/{id}", method=RequestMethod.GET)
public CommandeVente getVente(@PathVariable Long id){
	return venteRepository.getOne(id);
}	

@RequestMapping(value="/addDetailsVente/{idVente}/{idProduit}", method=RequestMethod.POST)
public DetailsVente saveDetailsVente(@PathVariable Long idVente,@PathVariable Integer idProduit,@RequestBody DetailsVente d){		
	CommandeVente cmdVente = new CommandeVente();
	cmdVente = venteRepository.getOne(idVente);
	Produit p = new Produit();
   p = produitRepository.getOne(idProduit);
	DetailsVente dv = new DetailsVente(d.getQuantite(), d.getPrixVente(), p, cmdVente);
return detailsVente.save(dv);
}
@RequestMapping(value="/detailsVente", method=RequestMethod.GET)
public List<DetailsVente> getAllDetailsVentes(@RequestParam(name="id") Long id){
	return detailsVente.getAllDetailsVentes(id);
}

@RequestMapping(value="/add_vente/{idUser}", method=RequestMethod.POST)
public CommandeVente saveVente(@PathVariable Long idUser,@RequestBody CommandeVente c){
	//Commercial com = new Commercial();
	//com = commercialRepository.findOne(idUser);
	Employe emp = new Employe();
	emp = employeRepository.getOne(idUser);
    CommandeVente cmdVente = new 
	CommandeVente(c.getDateCommande(), c.getEtatCommande(), c.getEtatFacture(), c.getNomClient(), c.getPrenomClient(), c.getTel(), c.getAdresseLivraison(), emp);
return venteRepository.save(cmdVente);
}
@RequestMapping(value="/deleteVente/{id}", method=RequestMethod.DELETE)
public boolean supprimerVente(@PathVariable Long id){
	venteRepository.deleteById(id);
	 return true;
}
}
