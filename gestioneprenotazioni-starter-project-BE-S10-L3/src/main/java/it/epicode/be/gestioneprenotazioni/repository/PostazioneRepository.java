package it.epicode.be.gestioneprenotazioni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.gestioneprenotazioni.model.Postazione;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	Page<Postazione> findByCodice(String codice, Pageable pageable);

}
