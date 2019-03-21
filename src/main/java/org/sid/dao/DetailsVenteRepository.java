package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.sid.entities.DetailsVente;

public interface DetailsVenteRepository extends JpaRepository<DetailsVente, Long> {
	@Query("select d,p,c from DetailsVente d,Produit p, CommandeVente c where d.produit = p.idProduit and c.idVente = d.commandeVente and c.idVente = :id ")
	public List<DetailsVente> getAllDetailsVentes(@Param("id") Long id);
}
