package org.sid.web;

import java.util.List;

import org.sid.dao.AbsenceRepository;
import org.sid.dao.CongeRepository;
import org.sid.dao.EmployeRepository;
import org.sid.dao.MouvementRepository;
import org.sid.dao.PaiementRepository;
import org.sid.dao.RecrutementRepository;
import org.sid.dao.RhRepository;
import org.sid.entities.Absence;
import org.sid.entities.Administrateur;
import org.sid.entities.CommandeVente;
import org.sid.entities.Conge;
import org.sid.entities.Employe;
import org.sid.entities.Mouvement;
import org.sid.entities.Paiement;
import org.sid.entities.Recrutement;
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
public class RhRestService {
	@Autowired
	private RhRepository rhRepository;
	@Autowired
	private CongeRepository congeRepository;
	@Autowired
	private AbsenceRepository absenceRepository;
	@Autowired
	private RecrutementRepository recrutementRepository;
	@Autowired
	private MouvementRepository mouvementRepository;
	@Autowired
	private PaiementRepository paiementRepository;
	@Autowired
	private EmployeRepository employeRepository;
	//conge service
	@RequestMapping(value="/chercherConge", method=RequestMethod.GET)
	public Page<Conge> chercherConge(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size) {
		return congeRepository.chercherConge("%"+mc+"%", new PageRequest(page, size));
	}
			
	@RequestMapping(value="/conges/{id}", method=RequestMethod.GET)
	public List<Conge> getConge(@PathVariable Long id){
		return congeRepository.getAllConges(id);
	}
	@RequestMapping(value="/conges", method=RequestMethod.GET)
	public List<Conge> getConges(){
		return congeRepository.findAll();
	}
	
	@RequestMapping(value="/add_conge/{id}", method=RequestMethod.POST)
	public Conge save(@PathVariable Long id, @RequestBody Conge c){
		Employe emp = new Employe();
		emp = employeRepository.getOne(id);
		Conge conge = new Conge(c.getDateDebut(), c.getDateFin(), emp);
		return congeRepository.save(conge);
	}
	//absence service
		@RequestMapping(value="/chercherAbsence", method=RequestMethod.GET)
		public Page<Absence> chercherAbsence(
				@RequestParam(name="mc", defaultValue="") String mc,
				@RequestParam(name="page", defaultValue="0") int page,
				@RequestParam(name="size", defaultValue="5") int size) {
			return absenceRepository.chercherAbsence("%"+mc+"%", new PageRequest(page, size));
		}
		
		@RequestMapping(value="/absence/{id}", method=RequestMethod.GET)
		public Absence getAbsence(@PathVariable Integer id){
			return absenceRepository.getOne(id);
		}	

		@RequestMapping(value="/absences", method=RequestMethod.GET)
		public List<Absence> getAbsences(){
			return absenceRepository.findAll();
		}
		
		@RequestMapping(value="/add_absence", method=RequestMethod.POST)
		public Absence save(@RequestBody Absence a){
			return absenceRepository.save(a);
		}
		
		//recrutement service
		@RequestMapping(value="/chercherRecrutement", method=RequestMethod.GET)
		public Page<Recrutement> chercherRecrutement(
				@RequestParam(name="mc", defaultValue="") String mc,
				@RequestParam(name="page", defaultValue="0") int page,
				@RequestParam(name="size", defaultValue="5") int size) {
			return recrutementRepository.chercherRecrutement("%"+mc+"%", new PageRequest(page, size));
		}
		
		@RequestMapping(value="/recrutement/{id}", method=RequestMethod.GET)
		public Absence getRecrutement(@PathVariable Integer id){
			return absenceRepository.getOne(id);
		}	

		@RequestMapping(value="/recrutements", method=RequestMethod.GET)
		public List<Recrutement> getRecrutements(){
			return recrutementRepository.findAll();
		}
		
		@RequestMapping(value="/add_Recrutement", method=RequestMethod.POST)
		public Recrutement save(@RequestBody Recrutement r){
			return recrutementRepository.save(r);
		}
		
		
		// paiement service
				@RequestMapping(value="/chercherPaiement", method=RequestMethod.GET)
				public Page<Paiement> chercherPaiement(
						@RequestParam(name="mc", defaultValue="") String mc,
						@RequestParam(name="page", defaultValue="0") int page,
						@RequestParam(name="size", defaultValue="5") int size) {
					return paiementRepository.chercherPaiement("%"+mc+"%", new PageRequest(page, size));
				}
				
				@RequestMapping(value="/paiement/{id}", method=RequestMethod.GET)
				public Paiement getPaiement(@PathVariable Integer id){
					return paiementRepository.getOne(id);
				}	

				@RequestMapping(value="/paiements", method=RequestMethod.GET)
				public List<Paiement> getPaiementys(){
					return paiementRepository.findAll();
				}
				
				@RequestMapping(value="/add_paiement", method=RequestMethod.POST)
				public Paiement save(@RequestBody Paiement p){
					return paiementRepository.save(p);
				}
		
	
				//mouvement service
				@RequestMapping(value="/chercherMouvement", method=RequestMethod.GET)
				public Page<Mouvement> chercherMouvement(
						@RequestParam(name="mc", defaultValue="") String mc,
						@RequestParam(name="page", defaultValue="0") int page,
						@RequestParam(name="size", defaultValue="5") int size) {
					return mouvementRepository.chercherMouvement("%"+mc+"%", new PageRequest(page, size));
				}
				
				@RequestMapping(value="/mouvement/{id}", method=RequestMethod.GET)
				public Mouvement getMouvement(@PathVariable Integer id){
					return mouvementRepository.getOne(id);
				}	

				@RequestMapping(value="/mouvements", method=RequestMethod.GET)
				public List<Mouvement> getMouvements(){
					return mouvementRepository.findAll();
				}
				
				@RequestMapping(value="/add_mouvement", method=RequestMethod.POST)
				public Mouvement save(@RequestBody Mouvement m){
					return mouvementRepository.save(m);
				}
	
	

}
