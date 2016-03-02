package co.madran.beeride.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.madran.beeride.model.dao.CarpoolRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Car;
import co.madran.beeride.model.domain.Carpool;
import co.madran.beeride.model.domain.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/carpools")
public class CarpoolHandler {
	private Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation().create();
	@Autowired
	private CarpoolRepository carpoolRepository;
	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public String getCarsOfUser(@RequestParam String username) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		User user = userRepository.findByUsername(username);
		List<Carpool> carpool = carpoolRepository.findByUser(user);
		response.add("data", gson.toJsonTree(carpool));
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "add", method = RequestMethod.POST)
	public String addCarpoolToUser(@RequestParam Long id,
			@RequestParam String username, @RequestParam String name) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);

		Carpool carpool = new Carpool();
		if (id == null) {
			User user = userRepository.findByUsername(username);
			carpool.setUser(user);
		} else {
			carpool = carpoolRepository.findOne(id);
		}
		carpool.setName(name);
		carpoolRepository.save(carpool);
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "delete", method = RequestMethod.POST)
	public String deleteCarpool(@RequestParam Long id) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		carpoolRepository.delete(id);
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "all")
	public String allCarpools(@RequestParam Integer page,
			@RequestParam Integer limit) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		Page<Carpool> carpoolPage = carpoolRepository.findAll(new PageRequest(
				page - 1, limit));
		List<Carpool> carpools = new LinkedList<>();
		for (Carpool car : carpoolPage) {
			carpools.add(car);
		}
		response.add("data", gson.toJsonTree(carpools));
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "{id}")
	public String getCar(@PathVariable Long id) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		response.add("data", gson.toJsonTree(carpoolRepository.findOne(id)));
		return response.toString();
	}
}
