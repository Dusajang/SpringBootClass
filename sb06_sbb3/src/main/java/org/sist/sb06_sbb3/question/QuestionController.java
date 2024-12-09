package org.sist.sb06_sbb3.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
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
	
	// 질문 등록 하기 이동...
	@GetMapping("/create")
	public void questionCreate(QuestionForm questionForm) {
		
	}
	
	/*
	// 질문 등록 하기
	@PostMapping("/create")
	public String questionCreate(@RequestParam("subject") String subject, @RequestParam("content") String content) {
		// 1. 질문 등록 작업
		this.questionService.create(subject, content);
		// 2. 질문 목록으로 리다이렉트
		return "redirect:/question/list";
	}
	*/
	
	// [2]
	// 질문 등록 하기 + 유효성 검사
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		// 1.
		if (bindingResult.hasErrors()) {
			return "/question/create";
		}//if
		
		String subject = questionForm.getSubject();
		String content = questionForm.getContent();
		this.questionService.create(subject, content);
		// 2. 질문 목록으로 리다이렉트
		return "redirect:/question/list";
	}
	
	
}// class
