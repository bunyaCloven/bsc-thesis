package co.madran.beeride.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Carpool {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  private static SimpleDateFormat sdf = new SimpleDateFormat(
      "MM dd hh:mm:ss yyyy");
  private User user;
  @Temporal(TemporalType.TIMESTAMP)
  private Date timex;
  private String time;
  private String name;
  private Path pathx;
  private Long path;
  private Car carx;
  private Long car;
  private Integer currentPassengers;

  public void setName(String name) {
    this.name = name;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setTime(Date time) {
    this.timex = time;
    this.time = sdf.format(time);
  }

  public void setPath(Path path) {
    this.pathx = path;
    this.path = path.getId();
  }

  public void setCar(Car car) {
    this.carx = car;
    this.car = car.getId();
  }

  public Car getCar() {
    return carx;
  }

  public Date getTime() {
    return timex;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public Integer getCurrentPassengers() {
    return currentPassengers;
  }

  public void setCurrentPassengers(int count) {
    currentPassengers = count;
  }

  public Path getPath() {
    return pathx;
  }
}
