package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
	@Query("select a from Absence a where a.dateAbsence like :x")
	public Page<Absence> chercherAbsence(@Param("x") String mc, Pageable pageable);
}
