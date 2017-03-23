package co.madran.beeride.model.domain;

import co.madran.beeride.http.PrintMedium;
import co.madran.beeride.model.Printable;

public class SeatUI implements Printable {
  private Long id;
  private String name;
  private String time;
  private String seats;
  private String plate;
  private String brand;
  private String start;
  private String end;

  public SeatUI(Seat seat) {
    Carpool carpool = seat.getCarpool();
    id = carpool.getId();
    name = carpool.getName();
    time = carpool.getTime().toString();
    seats = carpool.getCurrentPassengers() + "/"
        + carpool.getCar().getPassengerCount();
    plate = carpool.getCar().getPlate();
    brand = carpool.getCar().getBrand();
    start = carpool.getPath().getStart();
    end = carpool.getPath().getEnd();
  }

  @Override
  public void print(PrintMedium medium) {
    medium.addProperty("id", id);
    medium.addProperty("name", name);
    medium.addProperty("time", time);
    medium.addProperty("seats", seats);
    medium.addProperty("plate", plate);
    medium.addProperty("brand", brand);
    medium.addProperty("start", start);
    medium.addProperty("end", end);
  }
}
