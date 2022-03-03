package it.epicode.be.gestioneprenotazioni.common.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.be.gestioneprenotazioni.model.Citta;
import it.epicode.be.gestioneprenotazioni.model.Edificio;
import it.epicode.be.gestioneprenotazioni.model.Postazione;
import it.epicode.be.gestioneprenotazioni.model.Prenotazione;
import it.epicode.be.gestioneprenotazioni.model.TipoPostazione;
import it.epicode.be.gestioneprenotazioni.model.Utente;
import it.epicode.be.gestioneprenotazioni.repository.CittaRepository;
import it.epicode.be.gestioneprenotazioni.repository.EdificioRepository;
import it.epicode.be.gestioneprenotazioni.repository.PostazioneRepository;
import it.epicode.be.gestioneprenotazioni.repository.PrenotazioneRepository;
import it.epicode.be.gestioneprenotazioni.repository.UtenteRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe utility per l'inizializzazione del database all'avvio
 * dell'applicazione
 *
 */
@Component
@Slf4j
public class ApplicationStartupRunner implements CommandLineRunner {

	@Autowired
	private CittaRepository cittaRepository;

	@Autowired
	private EdificioRepository edificioRepository;

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private PostazioneRepository postazioneRepository;

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	@Override
	public void run(String... args) throws Exception {

		Citta citta = initCitta();

		List<Edificio> edifici = initEdificio(citta);

		initPostazione(edifici);

		initUtente();

		initPrenotazione();

	}

	/**
	 * Inserisce le postazioni per ciascun edificio
	 * 
	 * @param edifici lista di edifici da popolare con le postazioni
	 */
	private void initPostazione(List<Edificio> edifici) {

		for (Edificio edificio : edifici) {

			for (int i = 1; i < 4; i++) {
				Postazione postazione = new Postazione();
				postazione.setCodice("P_" + i + "_" + edificio.getNome());
				postazione.setDescrizione("Postazione " + postazione.getCodice());
				postazione.setEdificio(edificio);
				postazione.setNumeroMassimoOccupanti(2);
				postazione.setTipo(TipoPostazione.PRIVATO);
				postazioneRepository.save(postazione);
				log.info("Saved Postazione: {}", postazione.getCodice());

			}

		}

	}

	/**
	 * Genera la lista di edifici di una città
	 * 
	 * @param citta in cui sono ubicati gli edifici
	 * @return lista degli edifici
	 */
	private List<Edificio> initEdificio(Citta citta) {

		List<Edificio> edifici = new ArrayList<>();

		Edificio edificio = new Edificio();
		edificio.setCitta(citta);
		edificio.setIndirizzo("Via Nazionale, 6");
		edificio.setNome("Sede Centrale - Roma");
		edificioRepository.save(edificio);
		edifici.add(edificio);
		log.info("Saved Edificio: {}", edificio.getNome());

		edificio = new Edificio();
		edificio.setCitta(citta);
		edificio.setIndirizzo("Via Ponzio, 1");
		edificio.setNome("Sede Distaccata - Roma");
		edificioRepository.save(edificio);
		edifici.add(edificio);
		log.info("Saved Edificio: {}", edificio.getNome());

		return edifici;

	}

	/**
	 * Inserisce un utente
	 */
	private void initUtente() {

		Utente utente = new Utente();
		utente.setEmail("user@email.em");
		utente.setNome("Mario Rossi");
		utente.setUsername("m.rossi");
		utente.setPassword("test");
		utenteRepository.save(utente);
		log.info("Saved Utente: {}", utente.getNome());

	}

	private Citta initCitta() {

		Citta citta = new Citta();
		citta.setNome("Roma");
		cittaRepository.save(citta);
		log.info("Saved Città: {}", citta.getNome());
		return citta;

	}

	/**
	 * Inserisce una prenotazione di test recuperando l'unica città inserita e la
	 * prima postazione (id=1) e settando la data prenotata per il giorno successivo
	 * a quello dell'operazione
	 * 
	 */
	private void initPrenotazione() {
		Postazione postazione = postazioneRepository.getById(1L);
		Utente utente = utenteRepository.getById(1L);
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setUtente(utente);
		prenotazione.setPostazione(postazione);
		prenotazione.setDataPrenotata(LocalDate.now().plusDays(2));
		prenotazione.setDataPrenotazione(LocalDate.now());
		
		prenotazioneRepository.save(prenotazione);
	}

}
