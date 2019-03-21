package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sid.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
