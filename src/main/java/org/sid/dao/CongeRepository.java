package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.sid.entities.Conge;

public interface CongeRepository extends JpaRepository<Conge, Long> {
	@Query("select c from Conge c where c.dateDebut like :x")
	public Page<Conge> chercherConge(@Param("x") String mc, Pageable pageable);
	@Query("select c from Conge c where c.employe.idUtilisateur = :id ")
	public List<Conge> getAllConges(@Param("id") Long id);
}
