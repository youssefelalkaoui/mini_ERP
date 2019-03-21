package org.sid.dao;

import org.sid.entities.Commercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommercialRepository extends JpaRepository<Commercial, Long> {
	
	@Query("SELECT COUNT(c) FROM CommandeVente c where c.etatCommande = 'effectue'")
    public int getCountVentes();
	
	@Query("SELECT COUNT(c) FROM CommandeVente c where c.etatCommande = 'en cours'")
    public int getCountVentesEnCours();
	
	@Query("SELECT COUNT(c) FROM CommandeApprovisionnement c where c.etatCommande = 'effectue'")
    public int getCountAchats();
	
	@Query("SELECT COUNT(c) FROM CommandeApprovisionnement c where c.etatCommande = 'en cours'")
    public int getCountAchatsEnCours();
}
