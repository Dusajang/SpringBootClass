package org.sist.sist_project.consultationSchedule;

import java.security.Principal;

import org.sist.sist_project.page.Criteria;
import org.sist.sist_project.page.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@Controller
public class ConsultationScheduleController {

    private final ConsultationScheduleService consultationScheduleService;
    
    /* [1] 페이징 처리 X
    @GetMapping("/schedules")
    public String getAllSchedules(Model model) {
        model.addAttribute("schedules", consultationScheduleService.getAllSchedules());
        return "consultation_list";
    }
    */
    
    // [2] 페이징 처리 O
    @GetMapping("/schedules")
    public String list(Model model
          , @RequestParam(value = "page", defaultValue = "0") int page) {
       // 페이징 처리가 된 객체 : paging
       Page<ConsultationSchedule> paging = this.consultationScheduleService.getList(page);
       model.addAttribute("paging", paging); // 담기
       
       Criteria criteria = new Criteria(page+1, 10 );
        int total = (int)paging.getTotalElements();
        model.addAttribute("pageMaker",  new PageDTO(criteria, total));
        return "consultation_list_origin";
    }
    
    // 방문 상담 상세 보기
    @GetMapping("/consultation_detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
    	 ConsultationSchedule consultationSchedule = this.consultationScheduleService.getSchedule(id);
         model.addAttribute("consultationSchedule", consultationSchedule);
         
         return "consultation_detail_origin";
    }
    
    //방문 상담 수정 이동...
    @GetMapping("/consultation_edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
   	 ConsultationSchedule consultationSchedule = this.consultationScheduleService.getSchedule(id);
        model.addAttribute("consultationSchedule", consultationSchedule);
        
        return "consultation_edit_origin";
   }
    
    
    //방문상담 수정 처리...
    @PostMapping("/consultation_edit/{id}")
    public String postMethodName(ConsultationSchedule consultationSchedule, @PathVariable("id") Integer id) {
        
        
        return "consultation_list_origin";
    }
    

    
    
    
    
}//class
