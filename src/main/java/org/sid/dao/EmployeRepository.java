package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sid.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
	@Query("select e from Employe e where e.login = :login and e.password = :password")
	public Employe connect(@Param("login") String login,@Param("password") String password);
	
	@Query("select e from Employe e where e.nom like :x")
	public Page<Employe> chercher(@Param("x") String mc, Pageable pageable);
	
}
