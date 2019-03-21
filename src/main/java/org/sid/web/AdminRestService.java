package org.sid.web;

import org.sid.dao.AdministrateurRepository;
import org.sid.dao.CommercialRepository;
import org.sid.dao.CongeRepository;
import org.sid.dao.EmployeRepository;
import org.sid.dao.RhRepository;
import org.sid.entities.Administrateur;
import org.sid.entities.Commercial;
import org.sid.entities.Employe;
import org.sid.entities.RessourceHumaine;
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
public class AdminRestService {
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private AdministrateurRepository administrateurRepository;
	@Autowired
	private CommercialRepository commercialRepository;
	@Autowired
	private RhRepository rhRepository;
	@Autowired
	private CongeRepository congeRepository;
	
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public Employe getUser(@PathVariable Long id){
		return employeRepository.getOne(id);
	}
	
	@RequestMapping(value="/add_admin", method=RequestMethod.POST)
	public Administrateur save(@RequestBody Administrateur a){
		System.out.println("avatar :" + a.getAvatar());
		return administrateurRepository.save(a);
	}
	
	@RequestMapping(value="/add_commercial", method=RequestMethod.POST)
	public Commercial save(@RequestBody Commercial c){		
		return commercialRepository.save(c);
	}
	
	@RequestMapping(value="/add_rh", method=RequestMethod.POST)
	public RessourceHumaine save(@RequestBody RessourceHumaine rh){
		return rhRepository.save(rh);
	}
	@RequestMapping(value="/chercherUsers", method=RequestMethod.GET)
	public Page<Employe> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size) {
		return employeRepository.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	
	@RequestMapping(value="/edit-admin/{id}", method=RequestMethod.PUT)
	public Administrateur save(@PathVariable Long id, @RequestBody Administrateur a){
		a.setIdUtilisateur(id);
		return administrateurRepository.save(a);
	}
	@RequestMapping(value="/edit-rh/{id}", method=RequestMethod.PUT)
	public RessourceHumaine save(@PathVariable Long id, @RequestBody RessourceHumaine e){
		e.setIdUtilisateur(id);
		return rhRepository.save(e);
	}
	
	@RequestMapping(value="/edit-commercial/{id}", method=RequestMethod.PUT)
	public Commercial save(@PathVariable Long id, @RequestBody Commercial c){
		c.setIdUtilisateur(id);
		return commercialRepository.save(c);
	}	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id){
		 employeRepository.deleteById(id);
		 return true;
	}
	@RequestMapping(value="/conge/{id}", method=RequestMethod.DELETE)
	public boolean supprimerConge(@PathVariable Long id){
		 congeRepository.deleteById(id);
		 return true;
	}
	@RequestMapping(value="/getCountVentes", method=RequestMethod.GET)
	public int getCountVentes(){
		return commercialRepository.getCountVentes();
	}
	@RequestMapping(value="/getCountVentesEnCours", method=RequestMethod.GET)
	public int getCountVentesEnCours(){
		return commercialRepository.getCountVentesEnCours();
	}
	
	@RequestMapping(value="/getCountAchats", method=RequestMethod.GET)
	public int getCountAchats(){
		return commercialRepository.getCountAchats();
	}
	
	@RequestMapping(value="/getCountAchatsEnCours", method=RequestMethod.GET)
	public int getCountAchatsEnCours(){
		return commercialRepository.getCountAchatsEnCours();
	}
}
