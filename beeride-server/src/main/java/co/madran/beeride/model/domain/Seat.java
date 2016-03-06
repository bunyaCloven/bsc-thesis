package co.madran.beeride.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

@Entity
public class Seat {
	private @Id @Expose @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @Expose Carpool carpool;
	private @Expose User user;

	public void setCarpool(Carpool carpool) {
		this.carpool = carpool;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Carpool getCarpool() {
		return carpool;
	}
}
