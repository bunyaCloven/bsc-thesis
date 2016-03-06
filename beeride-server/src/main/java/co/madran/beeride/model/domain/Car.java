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
	private Integer currentPassengers;
	private @Expose String brand;

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setPassengerCount(Integer count) {
		passengerCount = count;
		if (currentPassengers == null) {
			currentPassengers = 0;
		}
	}

	public Long getId() {
		return id;
	}

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public Integer getCurrentPassengers() {
		return currentPassengers;
	}
}
