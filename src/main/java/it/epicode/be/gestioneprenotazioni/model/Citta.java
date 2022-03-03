package it.epicode.be.gestioneprenotazioni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Citta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;
	private String nome;

}
