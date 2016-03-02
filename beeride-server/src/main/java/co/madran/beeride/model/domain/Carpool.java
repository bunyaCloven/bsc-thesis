package co.madran.beeride.model.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
public class Carpool {
	private @Id @Expose @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private User user;
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	private @Expose String name;

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
