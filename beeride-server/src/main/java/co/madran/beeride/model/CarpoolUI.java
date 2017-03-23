package co.madran.beeride.model;

import co.madran.beeride.http.PrintMedium;
import co.madran.beeride.model.domain.Carpool;

public class CarpoolUI implements Printable {
  private Long id;
  private String seats;
  private String plate;
  private String brand;
  private String start;
  private String end;

  public CarpoolUI(Carpool carpool) {
    id = carpool.getId();
    seats = carpool.getCurrentPassengers() + "/"
        + carpool.getCar().getPassengerCount();
    plate = carpool.getCar().getPlate();
    brand = carpool.getCar().getBrand();
    start = carpool.getPath().getStart();
    end = carpool.getPath().getEnd();
  }

  /** FIXME: this solution is too verbose */
  @Override
  public void print(PrintMedium medium) {
    medium.addProperty("id", id);
    medium.addProperty("seats", seats);
    medium.addProperty("plate", plate);
    medium.addProperty("brand", brand);
    medium.addProperty("start", start);
    medium.addProperty("end", end);
  }

}
