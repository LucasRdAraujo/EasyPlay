package br.edu.infnet.easyplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/app")
	public String app() {
		return "app";
	}

}
