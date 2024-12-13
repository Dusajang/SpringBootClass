package org.sist.sb06_sbb8.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "/user/signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "/user/signup_form";
		}//if
		
		if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect","2개의 패스워드가 일치하지 않습니다.");
			return "/user/signup_form";
		}//if
		
		
		try {
			// 유효성 통과하고 회원가입 문제없을 때
			this.userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
			
		} catch (DataIntegrityViolationException e) {
			//PK(ID) 위배
			//UK 위배
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "/user/signup_form";
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed",e.getMessage());
			return "/user/signup_form";
	}
	
		
		
		return "redirect:/"; // 메인페이지로 간다...
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "/user/login_form";
	}
	
	
	
	
}//class
