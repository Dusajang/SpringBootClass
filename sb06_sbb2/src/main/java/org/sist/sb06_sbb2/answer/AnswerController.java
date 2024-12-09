package org.sist.sb06_sbb2.answer;

import org.sist.sb06_sbb2.question.Question;
import org.sist.sb06_sbb2.question.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
	
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	
	//<form th:action="@{|/answer/create/${question.id}|}" method="post">
	@PostMapping("/create/{id}")
	public String createAnswer( @PathVariable("id") Integer id, @RequestParam("content") String content) {
		Question question = this.questionService.getQuestion(id);
		this.answerService.create(question, content);
		return String.format("redirect:/question/detail/%s", id);
		
	}

}// class


