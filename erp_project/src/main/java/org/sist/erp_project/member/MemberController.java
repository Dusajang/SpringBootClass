package org.sist.erp_project.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.java.Log;

@Controller
@Log
public class MemberController {
	
	@GetMapping("/login")
	public String login(Model model) {
	    log.info(">로그인페이지 접근..");

	    return "sist/member/login";
	}
	
	@GetMapping("/join")
	public String join() {
		log.info(">회원가입페이지 접근..");
		
		return "sist/member/join";
	}
	
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("message", "로그인에 성공하셨습니다!");
        return "dashboard"; // 대시보드 페이지 이름
    }
    
    @GetMapping("/manage")
    public String manage() {
    
        return "sist/member/manage"; // 대시보드 페이지 이름
    }

}



/*
 이런 것도 가능
@GetMapping("/dashboard")
public String dashboard(Authentication authentication) {
    String role = authentication.getAuthorities().iterator().next().getAuthority();
    if ("ROLE_ADMIN".equals(role)) {
        return "redirect:/admin-dashboard";
    } else {
        return "redirect:/user-dashboard";
    }
}
*/