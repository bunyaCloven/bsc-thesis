package co.madran.beeride.controller;

import co.madran.beeride.model.CarpoolUI;
import co.madran.beeride.model.dao.CarRepository;
import co.madran.beeride.model.dao.CarpoolRepository;
import co.madran.beeride.model.dao.PathRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.Location;
import co.madran.beeride.model.domain.User;

import java.util.Collection;
import java.util.List;

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
@RequestMapping("/carpools")
public class CarpoolHandler {
  @Autowired
  private CarpoolRepository carpoolRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PathRepository pathRepository;
  @Autowired
  private CarRepository carRepository;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Collection<Carpool>> getCarpoolsOfUser(
      @RequestParam String username) {
    final User user = userRepository.findByUsername(username);
    final List<Carpool> carpools = carpoolRepository.findByUser(user);
    return new ResponseEntity<>(carpools, HttpStatus.OK);
  }

  @RequestMapping(path = "add", method = RequestMethod.POST)
  public ResponseEntity<Void> addCarpoolToUser(@RequestParam String username,
      Carpool carpool) {
    User user = userRepository.findByUsername(username);
    carpool.setUser(user);
    // if (path != null) {
    // carpool.setPath(pathRepository.findOne(path));
    // carpool.setCar(carRepository.findOne(car));
    // }
    // carpool.setName(name);
    // carpool.setTime(time);
    // if (carpool.getCurrentPassengers() == null) {
    // carpool.setCurrentPassengers(0);
    // }
    carpoolRepository.save(carpool);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "delete", method = RequestMethod.POST)
  public ResponseEntity<Void> deleteCarpool(@RequestParam Long id) {
    carpoolRepository.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "all")
  public ResponseEntity<List<Carpool>> allCarpools(@RequestParam Integer page,
      @RequestParam Integer limit, @RequestParam(required = false) String name,
      @RequestParam(required = false) String start) {
    List<Carpool> carpools;
    PageRequest currentPage = new PageRequest(page - 1, limit);
    if (name != null) {
      if (start != null && start != "") {
        Location location = Location.decode(start);
        carpools = carpoolRepository.findNonFullFiltered(name,
            location.getLatitude(), location.getLongitude(), currentPage);
      } else {
        carpools = carpoolRepository.findNonFullByName(name, currentPage);
      }
    } else {
      carpools = carpoolRepository.findNonFull(currentPage);
    }
    return new ResponseEntity<>(carpools, HttpStatus.OK);
  }

  @RequestMapping(path = "{id}")
  public ResponseEntity<CarpoolUI> getCarpool(@PathVariable Long id) {
    Carpool carpool = carpoolRepository.findOne(id);
    return new ResponseEntity<>(new CarpoolUI(carpool), HttpStatus.OK);
  }

  @RequestMapping(path = "driverView/{id}")
  public ResponseEntity<Carpool> getCarpoolOfDriver(@PathVariable Long id) {
    Carpool carpool = carpoolRepository.findOne(id);
    // FIXME: add seats
    // cp.addProperty("seats", carpool.getCurrentPassengers() + "/"
    // + carpool.getCar().getPassengerCount());
    return new ResponseEntity<>(carpool, HttpStatus.OK);
  }
}
