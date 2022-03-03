package it.epicode.be.gestioneprenotazioni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.gestioneprenotazioni.model.Citta;

public interface CittaRepository extends JpaRepository<Citta, Long> {

	Page<Citta> findByNome(String nome, Pageable pageable);

}
