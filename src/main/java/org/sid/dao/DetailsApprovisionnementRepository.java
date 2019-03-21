package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.sid.entities.DetailsApprovisionnement;

public interface DetailsApprovisionnementRepository extends JpaRepository<DetailsApprovisionnement, Long> {
	@Query("select d,p,c from DetailsApprovisionnement d,Produit p, CommandeApprovisionnement c where d.produit = p.idProduit and c.idApprovisionnement = d.commandeApprovisionnement and c.idApprovisionnement = :id ")
	public List<DetailsApprovisionnement> getAllDetails(@Param("id") Long id);
}
