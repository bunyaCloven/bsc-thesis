package co.madran.beeride.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private Long latitude;
	private Long longitude;
}
