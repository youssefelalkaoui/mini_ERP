package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.CommandeVente;

public interface CommandeVenteRepository extends JpaRepository<CommandeVente, Long> {
	@Query("select e from CommandeVente e where e.etatCommande like :x")
	public Page<CommandeVente> chercherVente(@Param("x") String mc, Pageable pageable);
}
