package co.madran.beeride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.madran.beeride.model.dao.CarRepository;
import co.madran.beeride.model.dao.CarpoolRepository;
import co.madran.beeride.model.dao.SeatRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Car;
import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.Seat;
import co.madran.beeride.model.domain.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/seats")
public class SeatHandler {
	private Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation().create();
	@Autowired
	private SeatRepository seatRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CarpoolRepository carpoolRepository;
	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping(path = "sign")
	public String signToCarpool(@RequestParam Long id,
			@RequestParam String username) {
		JsonObject response = new JsonObject();
		User user = userRepository.findByUsername(username);
		Carpool carpool = carpoolRepository.findOne(id);
		Car car = carpool.getCar();
		if (seatRepository.findByUserAndCarpool(user, carpool) != null) {
			response.addProperty("success", false);
			response.addProperty("message",
					"You have already signed to this carpool.");
		} else if (carpool.getCurrentPassengers() < car.getPassengerCount()) {
			Seat seat = new Seat();
			seat.setUser(user);
			seat.setCarpool(carpool);
			seatRepository.save(seat);
			carpool.setCurrentPassengers(carpool.getCurrentPassengers() + 1);
			carRepository.save(car);
			response.addProperty("success", true);
		} else {
			response.addProperty("success", false);
			response.addProperty("message", "Carpool has enough passengers");
		}
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public String getCarpools(@RequestParam String username,
			@RequestParam Integer page, @RequestParam Integer limit) {
		JsonObject response = new JsonObject();
		User user = userRepository.findByUsername(username);
		response.add("data", gson.toJsonTree(seatRepository.findCarpools(user,
				new PageRequest(page - 1, limit))));
		response.addProperty("success", true);
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "{id}")
	public String getSeatCarpool(@PathVariable Long id,
			@RequestParam String username) {
		JsonObject response = new JsonObject();
		Carpool carpool = carpoolRepository.findOne(id);
		User user = userRepository.findByUsername(username);
		Seat seat = seatRepository.findByUserAndCarpool(user, carpool);
		JsonObject seatObject = new JsonObject();
		seatObject.addProperty("id", seat.getCarpool().getId());
		seatObject.addProperty("name", seat.getCarpool().getName());
		seatObject.addProperty("time", seat.getCarpool().getTime().toString());
		seatObject.addProperty("seats", carpool.getCurrentPassengers() + "/"
				+ carpool.getCar().getPassengerCount());
		seatObject.addProperty("plate", seat.getCarpool().getCar().getPlate());
		seatObject.addProperty("brand", seat.getCarpool().getCar().getBrand());
		seatObject.addProperty("start", seat.getCarpool().getPath().getStart());
		response.addProperty("success", true);
		response.add("data", seatObject);
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "remove")
	public String removeFromCarpool(@RequestParam String username,
			@RequestParam Long id) {
		JsonObject response = new JsonObject();
		User user = userRepository.findByUsername(username);
		Carpool carpool = carpoolRepository.findOne(id);
		carpool.setCurrentPassengers(carpool.getCurrentPassengers() - 1);
		Seat seat = seatRepository.findByUserAndCarpool(user, carpool);
		seatRepository.delete(seat);
		response.addProperty("success", true);
		return response.toString();
	}
}
