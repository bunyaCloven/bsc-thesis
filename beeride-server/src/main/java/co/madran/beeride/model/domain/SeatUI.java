package co.madran.beeride.model.domain;

public class SeatUI {
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
}
