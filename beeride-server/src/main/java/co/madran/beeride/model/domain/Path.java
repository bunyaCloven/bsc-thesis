package co.madran.beeride.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

@Entity
public class Path {

	private @Id @Expose @GeneratedValue Long id;
	private @Expose String name;
	private User user;

	private @Expose String start;
	private @Expose String xend;

	private Location startLocation;
	private Location endLocation;

	public void setUser(User user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setEnd(String end) {
		this.xend = end;
	}

	public void setStartLocation(Location location) {
		startLocation = location;
	}

	public void setEndLocation(Location location) {
		endLocation = location;
	}
}
