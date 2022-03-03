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

import it.epicode.be.gestioneprenotazioni.model.Utente;
import it.epicode.be.gestioneprenotazioni.service.UtenteService;

@RestController
@RequestMapping("/api")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@GetMapping(path = "/utente")
	public ResponseEntity<Page<Utente>> findAll(Pageable pageable) {
		Page<Utente> findAll = utenteService.findAll(pageable);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/utente/{id}")
	public ResponseEntity<Utente> findById(@PathVariable(required = true) Long id) {
		Optional<Utente> find = utenteService.findById(id);

		if (find.isPresent()) {
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/utente")
	public ResponseEntity<Utente> save(@RequestBody Utente utente) {
		Utente save = utenteService.save(utente);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PutMapping(path = "/utente/{id}")
	public ResponseEntity<Utente> update(@PathVariable Long id, @RequestBody Utente utente) {
		Utente save = utenteService.update(id, utente);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/utente/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		utenteService.delete(id);
		return new ResponseEntity<>("Utente deleted", HttpStatus.OK);

	}

}
