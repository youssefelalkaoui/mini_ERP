package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
	@Query("select p from Paiement p where p.datePaiement like :x")
	public Page<Paiement> chercherPaiement(@Param("x") String mc, Pageable pageable);
}
