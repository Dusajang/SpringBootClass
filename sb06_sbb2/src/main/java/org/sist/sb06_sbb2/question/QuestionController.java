package org.sist.sb06_sbb2.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
	
	//private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	/*
	@GetMapping("/question/list")
	@ResponseBody
	public String list() {
		return "quesiton list";
	}
	*/
	
	@GetMapping("/list")
	public void list(Model model) {
		//List<Question> questionList = this.questionRepository.findAll();
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
	}
	
	// 질문 상세 보기
	@GetMapping("detail/{id}")
	public String datail(@PathVariable("id") Integer id, Model model) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "/question/detail";
	}
	
}
