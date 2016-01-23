package co.madran.beeride.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebHandler {
	@ResponseBody
	@RequestMapping(value = "/")
	public String getRoot(Model model) {
		return "hello";
	}
}
