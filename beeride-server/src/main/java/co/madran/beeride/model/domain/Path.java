package co.madran.beeride.model.domain;

import co.madran.beeride.http.PrintMedium;
import co.madran.beeride.model.Printable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Path implements Printable {

  private @Id @GeneratedValue Long id;
  private String name;
  private User user;

  private String start;
  private @Column(name = "xend") String end;

  private Location startLocation;
  private Location endLocation;

  @Override
  public void print(PrintMedium medium) {
    medium.addProperty("id", id);
    medium.addProperty("name", name);
    // medium.addProperty("user", user);
    medium.addProperty("start", start);
    medium.addProperty("end", end);
  }

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
    this.end = end;
  }

  //
  // public void setStartLocation(Location location) {
  // startLocation = location;
  // }
  //
  // public void setEndLocation(Location location) {
  // endLocation = location;
  // }
  //
  public Long getId() {
    return id;
  }

  public String getStart() {
    return start;
  }

  public String getEnd() {
    return end;
  }

}
