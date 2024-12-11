package org.sist.sb06_sbb7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

	@GetMapping(value = {"/", "index"})
	public String index() {
		System.out.println("index");
		return "/index";
	}
	
}// class