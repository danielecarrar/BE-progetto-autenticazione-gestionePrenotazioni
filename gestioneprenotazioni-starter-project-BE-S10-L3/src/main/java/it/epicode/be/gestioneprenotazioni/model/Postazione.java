package it.epicode.be.gestioneprenotazioni.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;
	private String codice;
	private String descrizione;
	private Integer numeroMassimoOccupanti;

	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;

	@ManyToOne
	private Edificio edificio;

}
