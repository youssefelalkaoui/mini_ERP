package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.Recrutement;

public interface RecrutementRepository extends JpaRepository<Recrutement, Integer> {
	@Query("select r from Recrutement r where r.dateRecrutement like :x")
	public Page<Recrutement> chercherRecrutement(@Param("x") String mc, Pageable pageable);
}