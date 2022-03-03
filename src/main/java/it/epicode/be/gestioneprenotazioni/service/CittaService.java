package it.epicode.be.gestioneprenotazioni.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.gestioneprenotazioni.common.util.exception.PrenotazioneException;
import it.epicode.be.gestioneprenotazioni.model.Citta;
import it.epicode.be.gestioneprenotazioni.repository.CittaRepository;

@Service
public class CittaService {

	@Autowired
	CittaRepository cittaRepository;

	public Optional<Citta> findById( Long id) {
		return cittaRepository.findById(id);
	}
	
	public Page<Citta> findByNome(String nome, Pageable pageable) {
		return cittaRepository.findByNome(nome, pageable);
	}

	public Page<Citta> findAll(Pageable pageable) {
		return cittaRepository.findAll(pageable);
	}

	public Citta save(Citta citta) {
		return cittaRepository.save(citta);
	}

	public Citta update(Long id, Citta citta) {
		Optional<Citta> cittaResult = cittaRepository.findById(id);

		if (cittaResult.isPresent()) {
			Citta cittaUpdate = cittaResult.get();
			cittaUpdate.setNome(citta.getNome());
			cittaRepository.save(cittaUpdate);
			return cittaUpdate;
		} else {
			throw new PrenotazioneException("Città non aggiornata");
		}

	}
	
	public void delete(Long id) {
		cittaRepository.deleteById(id);
	}

}
