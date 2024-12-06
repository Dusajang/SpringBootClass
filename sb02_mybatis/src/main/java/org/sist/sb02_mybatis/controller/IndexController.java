package org.sist.sb02_mybatis.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Log
public class IndexController {
	/*
	@GetMapping("/index")
	@ResponseBody
	public String index() {
		return "hello world!";
	}
	*/
	@GetMapping("/index")
	public void index() {
		System.out.println("/index 컨트롤러 메서드");
	}
	
	
}
