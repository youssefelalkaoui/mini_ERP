package org.sid.dao;

import org.sid.entities.RessourceHumaine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RhRepository extends JpaRepository<RessourceHumaine, Long> {
	
}
