package it.epicode.be.gestioneprenotazioni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.gestioneprenotazioni.model.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {

	Page<Edificio> findByNome(String nome, Pageable pageable);

}
