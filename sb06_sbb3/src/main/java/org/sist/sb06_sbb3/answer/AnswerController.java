package org.sist.sb06_sbb3.answer;

import org.sist.sb06_sbb3.question.Question;
import org.sist.sb06_sbb3.question.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
	
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	/* [1]
	//<form th:action="@{|/answer/create/${question.id}|}" method="post">
	@PostMapping("/create/{id}")
	public String createAnswer( @PathVariable("id") Integer id, @RequestParam("content") String content) {
		Question question = this.questionService.getQuestion(id);
		this.answerService.create(question, content);
		return String.format("redirect:/question/detail/%s", id);
		
	}
	*/
	
	//[2]
	@PostMapping("/create/{id}")
	public String createAnswer( @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult, Model model) {
		// 1.
		Question question = this.questionService.getQuestion(id);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "/question/detail";
		}//if
							// answerForm.getContent()대신에 객체로 받는게 좋다. 이 작업에서는 다른 코딩 안 고치려고....
		this.answerService.create(question, answerForm.getContent());
		
		return String.format("redirect:/question/detail/%s", id);
		
	}

}// class


