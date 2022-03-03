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

import it.epicode.be.gestioneprenotazioni.model.Postazione;
import it.epicode.be.gestioneprenotazioni.service.PostazioneService;

@RestController
@RequestMapping("/api")
public class PostazioneController {

	@Autowired
	private PostazioneService postazioneService;

	@GetMapping(path = "/postazione")
	public ResponseEntity<Page<Postazione>> findAll(Pageable pageable) {
		Page<Postazione> findAll = postazioneService.findAll(pageable);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/postazione/{id}")
	public ResponseEntity<Postazione> findById(@PathVariable(required = true) Long id) {
		Optional<Postazione> find = postazioneService.findById(id);

		if (find.isPresent()) {
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/postazione")
	public ResponseEntity<Postazione> save(@RequestBody Postazione postazione) {
		Postazione save = postazioneService.save(postazione);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PutMapping(path = "/postazione/{id}")
	public ResponseEntity<Postazione> update(@PathVariable Long id, @RequestBody Postazione postazione) {
		Postazione save = postazioneService.update(id, postazione);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/postazione/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		postazioneService.delete(id);
		return new ResponseEntity<>("Postazione deleted", HttpStatus.OK);

	}

}
