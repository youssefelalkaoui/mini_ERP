package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.CommandeApprovisionnement;

public interface CommandeApprovisionnementRepository extends JpaRepository<CommandeApprovisionnement, Long> {
	@Query("select e from CommandeApprovisionnement e where e.etatCommande like :x")
	public Page<CommandeApprovisionnement> chercher(@Param("x") String mc, Pageable pageable);
}
