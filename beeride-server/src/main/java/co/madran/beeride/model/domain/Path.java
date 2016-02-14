package co.madran.beeride.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

@Entity
public class Path {

	private @Id @Expose @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @Expose String name;
	private User user;
	private @Expose Location start;
	private @Expose List<Location> passed;
	private @Expose Location end;

	public void setUser(User user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}
}
