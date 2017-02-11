package co.madran.beeride.controller;

import co.madran.beeride.model.dao.CarRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Car;
import co.madran.beeride.model.domain.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cars")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST })
public class CarHandler {
  private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private CarRepository carRepository;

  @ResponseBody
  @RequestMapping(method = RequestMethod.GET)
  public String getCarsOfUser(@RequestParam String username) {
    final JsonObject response = new JsonObject();
    response.addProperty("success", true);
    final User user = userRepository.findByUsername(username);
    final List<Car> car = carRepository.findByUser(user);
    response.add("data", gson.toJsonTree(car));
    return response.toString();
  }

  @ResponseBody
  @RequestMapping(path = "add", method = RequestMethod.POST)
  public String addCarToUser(@RequestParam Long id, @RequestParam String username,
      @RequestParam String name, @RequestParam String brand, @RequestParam Integer passengerCount,
      @RequestParam String plate) {
    JsonObject response = new JsonObject();
    response.addProperty("success", true);

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
    return response.toString();
  }

  @ResponseBody
  @RequestMapping(path = "delete", method = RequestMethod.POST)
  public String deleteCar(@RequestParam Long id) {
    final JsonObject response = new JsonObject();
    response.addProperty("success", true);
    carRepository.delete(id);
    return response.toString();
  }

  @ResponseBody
  @RequestMapping(path = "all")
  public String allCars(@RequestParam Integer page, @RequestParam Integer limit) {
    final JsonObject response = new JsonObject();
    response.addProperty("success", true);
    final Page<Car> carPage = carRepository.findAll(new PageRequest(page - 1, limit));
    final List<Car> cars = new LinkedList<>();
    for (final Car car : carPage) {
      cars.add(car);
    }
    response.add("data", gson.toJsonTree(cars));
    return response.toString();
  }

  @ResponseBody
  @RequestMapping(path = "{id}")
  public String getCar(@PathVariable Long id) {
    final JsonObject response = new JsonObject();
    response.addProperty("success", true);
    response.add("data", gson.toJsonTree(carRepository.findOne(id)));
    return response.toString();
  }
}
