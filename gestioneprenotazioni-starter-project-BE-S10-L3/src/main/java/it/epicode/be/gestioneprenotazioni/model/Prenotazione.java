package it.epicode.be.gestioneprenotazioni.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;

	@ManyToOne
	@NonNull
	private Utente utente;

	@ManyToOne
	@NonNull
	private Postazione postazione;

	@NonNull
	private LocalDate dataPrenotata;

	private LocalDate dataPrenotazione;

}
