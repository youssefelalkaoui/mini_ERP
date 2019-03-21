package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sid.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}
