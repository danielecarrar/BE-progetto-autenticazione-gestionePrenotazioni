package it.epicode.be.gestioneprenotazioni.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.gestioneprenotazioni.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Page<Utente> findByNome(String nome, Pageable pageable);

	Optional<Utente> findByUsername(String username);

}
