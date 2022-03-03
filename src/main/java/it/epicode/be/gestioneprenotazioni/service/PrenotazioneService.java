package it.epicode.be.gestioneprenotazioni.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.gestioneprenotazioni.common.util.exception.PrenotazioneException;
import it.epicode.be.gestioneprenotazioni.model.Prenotazione;
import it.epicode.be.gestioneprenotazioni.model.Utente;
import it.epicode.be.gestioneprenotazioni.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	public Optional<Prenotazione> findById(Long id) {
		return prenotazioneRepository.findById(id);
	}

	public Page<Prenotazione> findByUtente(Utente utente, Pageable pageable) {
		return prenotazioneRepository.findByUtente(utente, pageable);
	}

	public Page<Prenotazione> findAll(Pageable pageable) {
		return prenotazioneRepository.findAll(pageable);
	}

	public Prenotazione save(Prenotazione postazione) {
		return prenotazioneRepository.save(postazione);
	}

	public Prenotazione update(Long id, Prenotazione prenotazione) {
		Optional<Prenotazione> prenotazioneResult = prenotazioneRepository.findById(id);

		if (prenotazioneResult.isPresent()) {
			Prenotazione prenotazioneUpdate = prenotazioneResult.get();
			prenotazioneUpdate.setDataPrenotata(prenotazione.getDataPrenotata());
			prenotazioneUpdate.setDataPrenotazione(prenotazione.getDataPrenotazione());
			prenotazioneUpdate.setPostazione(prenotazione.getPostazione());
			prenotazioneUpdate.setUtente(prenotazione.getUtente());
			prenotazioneRepository.save(prenotazioneUpdate);
			return prenotazioneUpdate;
		} else {
			throw new PrenotazioneException("Prenotazione non aggiornata");
		}

	}

	public void delete(Long id) {
		prenotazioneRepository.deleteById(id);
	}

}
