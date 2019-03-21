package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.Mouvement;


public interface MouvementRepository extends JpaRepository<Mouvement, Integer> {
	@Query("select m from Mouvement m where m.dateMouvement like :x")
	public Page<Mouvement> chercherMouvement(@Param("x") String mc, Pageable pageable);
}
