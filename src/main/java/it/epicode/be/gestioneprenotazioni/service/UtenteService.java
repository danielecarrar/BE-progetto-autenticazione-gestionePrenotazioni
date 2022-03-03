package it.epicode.be.gestioneprenotazioni.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.gestioneprenotazioni.common.util.exception.PrenotazioneException;
import it.epicode.be.gestioneprenotazioni.model.Utente;
import it.epicode.be.gestioneprenotazioni.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository utenteRepository;

	public Optional<Utente> findById(Long id) {
		return utenteRepository.findById(id);
	}

	public Page<Utente> findByNome(String nome, Pageable pageable) {
		return utenteRepository.findByNome(nome, pageable);
		
	}

	public Optional<Utente> findByUsername(String username) {
		return utenteRepository.findByUsername(username);
	}

	public Page<Utente> findAll(Pageable pageable) {
		return utenteRepository.findAll(pageable);
	}

	public Utente save(Utente utente) {
		return utenteRepository.save(utente);
	}

	public Utente update(Long id, Utente utente) {
		Optional<Utente> utenteResult = utenteRepository.findById(id);

		if (utenteResult.isPresent()) {
			Utente utenteUpdate = utenteResult.get(); // IMPORTANTE
			utenteUpdate.setNome(utente.getNome());
			utenteUpdate.setUsername(utente.getUsername());
			utenteUpdate.setEmail(utente.getEmail());
			utenteUpdate.setPassword(utente.getPassword());
			utenteUpdate.setActive(utente.getActive());
			utenteRepository.save(utenteUpdate);
			return utenteUpdate;
		} else {
			throw new PrenotazioneException("Utente non aggiornato");
		}

	}

	public void delete(Long id) {
		utenteRepository.deleteById(id);
	}

}
