package com.fanou.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanou.bibliotheque.model.Exemplaire;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {}
