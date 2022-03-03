package it.epicode.be.gestioneprenotazioni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.gestioneprenotazioni.model.Prenotazione;
import it.epicode.be.gestioneprenotazioni.model.Utente;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	Page<Prenotazione> findByUtente(Utente utente, Pageable pageable);

}
