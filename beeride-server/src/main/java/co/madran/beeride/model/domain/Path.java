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
	private @Expose Location start;
	private @Expose Location end;

	public void setUser(User user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStart(Location start) {
		this.start = start;
	}

	public void setEnd(Location end) {
		this.end = end;
	}
}
