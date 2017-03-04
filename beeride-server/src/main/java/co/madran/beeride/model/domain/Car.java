package co.madran.beeride.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  private String name;
  private User user;
  private Integer passengerCount;
  private String brand;
  private String plate;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Long getId() {
    return id;
  }

  public void setPassengerCount(Integer count) {
    this.passengerCount = count;
  }

  public Integer getPassengerCount() {
    return passengerCount;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public String getBrand() {
    return brand;
  }
}
