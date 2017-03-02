package co.madran.beeride.controller;

import co.madran.beeride.model.dao.CarRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Car;
import co.madran.beeride.model.domain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST })
public class CarHandler {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private CarRepository carRepository;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Car>> getCarsOfUser(
      @RequestParam String username) {
    return new ResponseEntity<>(
        carRepository.findByUser(userRepository.findByUsername(username)),
        HttpStatus.OK);
  }

  @RequestMapping(path = "add", method = RequestMethod.POST)
  public ResponseEntity<Void> addCarToUser(@RequestParam Long id,
      @RequestParam String username, @RequestParam String name,
      @RequestParam String brand, @RequestParam Integer passengerCount,
      @RequestParam String plate) {

    Car car = new Car();
    if (id == null) {
      final User user = userRepository.findByUsername(username);
      car.setUser(user);
    } else {
      car = carRepository.findOne(id);
    }
    car.setName(name);
    car.setBrand(brand);
    car.setPlate(plate);
    car.setPassengerCount(passengerCount);
    carRepository.save(car);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "delete", method = RequestMethod.POST)
  public ResponseEntity<Void> deleteCar(@RequestParam Long id) {
    carRepository.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "all")
  public ResponseEntity<Page<Car>> allCars(@RequestParam Integer page,
      @RequestParam Integer limit) {
    return new ResponseEntity<>(
        carRepository.findAll(new PageRequest(page - 1, limit)), HttpStatus.OK);
  }

  @RequestMapping(path = "{id}")
  public ResponseEntity<Car> getCar(@PathVariable Long id) {
    return new ResponseEntity<>(carRepository.findOne(id), HttpStatus.OK);
  }
}
