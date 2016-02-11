package co.madran.beeride.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.madran.beeride.model.dao.PathRepository;
import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.Path;
import co.madran.beeride.model.domain.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Controller
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST })
public class WebHandler {
	private Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation().create();
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PathRepository pathRepository;

	@ResponseBody
	@RequestMapping("/paths")
	public String getPathsOfUser(@RequestParam String username) {
		JsonObject response = new JsonObject();
		response.addProperty("success", true);
		User user = userRepository.findByUsername(username);
		List<Path> path = pathRepository.findByUser(user);
		response.add("data", gson.toJsonTree(path));
		return response.toString();
	}
}
