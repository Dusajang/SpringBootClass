package org.sist.sb03_jpa_oracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@RequestMapping("/board")
@Controller
@Log
public class BoardController {

	@GetMapping("/list")
	public void boardList() {
		System.out.println("board/list@@@@@@@@@@@@");
	}
}
