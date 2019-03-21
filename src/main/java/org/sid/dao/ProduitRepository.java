package org.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sid.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
