package co.madran.beeride.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  private Carpool carpool;
  private User user;

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
