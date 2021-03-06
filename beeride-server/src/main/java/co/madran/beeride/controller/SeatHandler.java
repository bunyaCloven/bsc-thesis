package co.madran.beeride.controller;

import co.madran.beeride.model.dao.CarRepository;
import co.madran.beeride.model.dao.CarpoolRepository;
import co.madran.beeride.model.dao.SeatRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Car;
import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.Seat;
import co.madran.beeride.model.domain.SeatUI;
import co.madran.beeride.model.domain.User;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatHandler {
  @Autowired
  private SeatRepository seatRepository;
  @Autowired
  private CarRepository carRepository;
  @Autowired
  private CarpoolRepository carpoolRepository;
  @Autowired
  private UserRepository userRepository;

  @RequestMapping(path = "sign")
  public ResponseEntity<Void> signToCarpool(@RequestParam Long id,
      @RequestParam String username) {
    final HttpStatus status;
    User user = userRepository.findByUsername(username);
    Carpool carpool = carpoolRepository.findOne(id);
    Car car = carpool.getCar();
    if (seatRepository.findByUserAndCarpool(user, carpool) != null) {
      status = HttpStatus.CONFLICT;
      // response.addProperty("message",
      // "You have already signed to this carpool.");
    } else if (carpool.getCurrentPassengers() < car.getPassengerCount()) {
      Seat seat = new Seat();
      seat.setUser(user);
      seat.setCarpool(carpool);
      seatRepository.save(seat);
      // FIXME: HERESY
      carpool.setCurrentPassengers(carpool.getCurrentPassengers() + 1);
      carRepository.save(car);
      status = HttpStatus.OK;
    } else {
      status = HttpStatus.UNPROCESSABLE_ENTITY;
      // response.addProperty("message", "Carpool has enough passengers");
    }
    return new ResponseEntity<>(status);
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Collection<Carpool>> getCarpools(
      @RequestParam String username, @RequestParam Integer page,
      @RequestParam Integer limit) {
    User user = userRepository.findByUsername(username);
    return new ResponseEntity<>(
        seatRepository.findCarpools(user, new PageRequest(page - 1, limit)),
        HttpStatus.OK);
  }

  @RequestMapping(path = "{id}")
  public ResponseEntity<SeatUI> getSeatCarpool(@PathVariable Long id,
      @RequestParam String username) {
    // final JsonObject response = new JsonObject();
    Carpool carpool = carpoolRepository.findOne(id);
    User user = userRepository.findByUsername(username);
    Seat seat = seatRepository.findByUserAndCarpool(user, carpool);
    // JsonObject seatObject = new JsonObject();
    // seatObject.addProperty("id", seat.getCarpool().getId());
    // seatObject.addProperty("name", seat.getCarpool().getName());
    // seatObject.addProperty("time", seat.getCarpool().getTime().toString());
    // seatObject.addProperty("seats", carpool.getCurrentPassengers() + "/"
    // + carpool.getCar().getPassengerCount());
    // seatObject.addProperty("plate", seat.getCarpool().getCar().getPlate());
    // seatObject.addProperty("brand", seat.getCarpool().getCar().getBrand());
    // seatObject.addProperty("start", seat.getCarpool().getPath().getStart());
    // seatObject.addProperty("end", seat.getCarpool().getPath().getEnd());
    // response.addProperty("success", true);
    // response.add("data", seatObject);
    // return response.toString();
    return new ResponseEntity<>(new SeatUI(seat), HttpStatus.OK);
  }

  @RequestMapping(path = "remove")
  public ResponseEntity<Void> removeFromCarpool(@RequestParam String username,
      @RequestParam Long id) {
    User user = userRepository.findByUsername(username);
    Carpool carpool = carpoolRepository.findOne(id);
    carpool.setCurrentPassengers(carpool.getCurrentPassengers() - 1);
    Seat seat = seatRepository.findByUserAndCarpool(user, carpool);
    seatRepository.delete(seat);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
