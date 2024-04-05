package com.fanou.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanou.bibliotheque.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long>{}
