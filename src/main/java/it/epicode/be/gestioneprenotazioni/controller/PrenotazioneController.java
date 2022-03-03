package it.epicode.be.gestioneprenotazioni.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.gestioneprenotazioni.model.Prenotazione;
import it.epicode.be.gestioneprenotazioni.service.PrenotazioneService;

@RestController
@RequestMapping("/api")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService prenotazioneService;

	@GetMapping(path = "/prenotazione")
	public ResponseEntity<Page<Prenotazione>> findAll(Pageable pageable) {
		Page<Prenotazione> findAll = prenotazioneService.findAll(pageable);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/prenotazione/{id}")
	public ResponseEntity<Prenotazione> findById(@PathVariable(required = true) Long id) {
		Optional<Prenotazione> find = prenotazioneService.findById(id);

		if (find.isPresent()) {
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/prenotazione")
	public ResponseEntity<Prenotazione> save(@RequestBody Prenotazione prenotazione) {
		Prenotazione save = prenotazioneService.save(prenotazione);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PutMapping(path = "/prenotazione/{id}")
	public ResponseEntity<Prenotazione> update(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
		Prenotazione save = prenotazioneService.update(id, prenotazione);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/prenotazione/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		prenotazioneService.delete(id);
		return new ResponseEntity<>("Prenotazione deleted", HttpStatus.OK);

	}
	
}
