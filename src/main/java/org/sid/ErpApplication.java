package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.sid.dao.*;
import org.sid.entities.Administrateur;
import org.sid.entities.Commercial;
import org.sid.entities.RessourceHumaine;

@SpringBootApplication
public class ErpApplication implements CommandLineRunner {
	
    @Autowired
    private AdministrateurRepository administrateurRepository ;
    @Autowired
    private CommercialRepository commercialRepository ;
    @Autowired
    private RhRepository rhRepository ;
   
	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// Décommenter le bloc au-dessous, exécuter l'application une seule fois, vérifier la bdd si les profils sont crées, recommenter le bloc
	
		/*Administrateur admin = new Administrateur("bentalha", "hicham", df.parse("19/01/1990"), "admin", "admin", "hicham@gmail", "photo.jpg",5557.33,"");
		administrateurRepository.save(admin);
		Commercial commercial = new Commercial("el alkaoui", "youssef", df.parse("20/11/1989"), "commercial", "commercial", "youssef@gmail", "photo.jpg",5557.33,"");
		commercialRepository.save(commercial);
		RessourceHumaine rh = new RessourceHumaine("taguine", "adil", df.parse("15/06/1990"), "rh", "rh", "adil@gmail", "photo.jpg",5557.33,"");
		rhRepository.save(rh);*/
		
	}
}
