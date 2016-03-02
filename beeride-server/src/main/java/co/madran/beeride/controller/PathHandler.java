package co.madran.beeride.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.madran.beeride.model.dao.LocationRepository;
import co.madran.beeride.model.dao.PathRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Location;
import co.madran.beeride.model.domain.Path;
import co.madran.beeride.model.domain.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/paths")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST })
public class PathHandler {
	private Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation().create();
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PathRepository pathRepository;
	@Autowired
	private LocationRepository locationRepository;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public String getPathsOfUser(@RequestParam String username) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		User user = userRepository.findByUsername(username);
		List<Path> path = pathRepository.findByUser(user);
		response.add("data", gson.toJsonTree(path));
		return response.toString();
	}

	@ResponseBody
	@RequestMapping(path = "add", method = RequestMethod.POST)
	public String addPathToUser(@RequestParam Long id,
			@RequestParam String username, @RequestParam String name,
			@RequestParam String start, @RequestParam String xend) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		Path path = new Path();
		if (id == null) {
			User user = userRepository.findByUsername(username);
			path.setUser(user);
		} else {
			path = pathRepository.findOne(id);
		}
		path.setName(name);
		path.setStart(start);
		path.setEnd(xend);
		path.setStartLocation(locationRepository.save(Location.decode(start)));
		path.setEndLocation(locationRepository.save(Location.decode(xend)));
		pathRepository.save(path);
		return response.toString();
	}

	@RequestMapping(path = "delete", method = RequestMethod.POST)
	public void deletePath(@RequestParam Long id) {
		pathRepository.delete(id);
	}

	@ResponseBody
	@RequestMapping(path = "{id}")
	public String getPath(@PathVariable Long id) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		response.add("data", gson.toJsonTree(pathRepository.findOne(id)));
		return response.toString();
	}
}
