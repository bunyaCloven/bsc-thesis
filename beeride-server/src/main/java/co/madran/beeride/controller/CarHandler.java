package co.madran.beeride.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.madran.beeride.model.dao.CarRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Car;
import co.madran.beeride.model.domain.Path;
import co.madran.beeride.model.domain.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/cars")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST })
public class CarHandler {
	private Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation().create();
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CarRepository carRepository;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public String getCarsOfUser(@RequestParam String username) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		User user = userRepository.findByUsername(username);
		List<Car> car = carRepository.findByUser(user);
		response.add("data", gson.toJsonTree(car));
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "add", method = RequestMethod.POST)
	public String addCarToUser(@RequestParam String username,
			@RequestParam String name) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		User user = userRepository.findByUsername(username);
		Car car = new Car();
		car.setName(name);
		car.setUser(user);
		carRepository.save(car);
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "delete", method = RequestMethod.POST)
	public String deleteCar(@RequestParam Long id) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		carRepository.delete(id);
		return response.toString();
	}
}
