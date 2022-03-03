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

import it.epicode.be.gestioneprenotazioni.model.Edificio;
import it.epicode.be.gestioneprenotazioni.service.EdificioService;

@RestController
@RequestMapping("/api")
public class EdificioController {

	@Autowired
	private EdificioService edificioService;

	@GetMapping(path = "/edificio")
	public ResponseEntity<Page<Edificio>> findAll(Pageable pageable) {
		Page<Edificio> findAll = edificioService.findAll(pageable);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/edificio/{id}")
	public ResponseEntity<Edificio> findById(@PathVariable(required = true) Long id) {
		Optional<Edificio> find = edificioService.findById(id);

		if (find.isPresent()) {
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/edificio")
	public ResponseEntity<Edificio> save(@RequestBody Edificio edificio) {
		Edificio save = edificioService.save(edificio);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PutMapping(path = "/edificio/{id}")
	public ResponseEntity<Edificio> update(@PathVariable Long id, @RequestBody Edificio edificio) {
		Edificio save = edificioService.update(id, edificio);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/edificio/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		edificioService.delete(id);
		return new ResponseEntity<>("Edificio deleted", HttpStatus.OK);

	}

}
