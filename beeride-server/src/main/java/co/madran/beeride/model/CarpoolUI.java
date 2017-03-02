package co.madran.beeride.model;

import co.madran.beeride.model.domain.Carpool;

public class CarpoolUI {
  private String seats;
  private String plate;
  private String brand;
  private String start;
  private String end;

  public CarpoolUI(Carpool carpool) {
    seats = carpool.getCurrentPassengers() + "/"
        + carpool.getCar().getPassengerCount();
    plate = carpool.getCar().getPlate();
    brand = carpool.getCar().getBrand();
    start = carpool.getPath().getStart();
    end = carpool.getPath().getEnd();
  }

}
