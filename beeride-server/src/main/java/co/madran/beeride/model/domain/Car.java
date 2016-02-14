package co.madran.beeride.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

@Entity
public class Car {
	private @Id @Expose @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @Expose String name;
	private User user;
	private @Expose Integer passengerCount;

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
