package org.sist.sb02_mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@RequestMapping("/board")
@Controller
@Log
public class BoardController {

	@GetMapping("/board/list")
	public void boardList() {
		System.out.println("board/list@@@@@@@@@@@@");
	}
}
