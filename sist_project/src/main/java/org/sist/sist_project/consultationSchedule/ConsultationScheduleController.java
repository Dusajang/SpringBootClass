package org.sist.sist_project.consultationSchedule;

import java.security.Principal;
import java.util.Optional;

import org.sist.sist_project.page.Criteria;
import org.sist.sist_project.page.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@Controller
public class ConsultationScheduleController {

    private final ConsultationScheduleService consultationScheduleService;
    
    // 방문상담 작성페이지 이동
    @GetMapping("/consultation_create")
    public String create() {
    	
    	return "consultation_create_test";
    }
    
    
    
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
    public String updateConsultationSchedule(
            @PathVariable("id") Integer id,
            @ModelAttribute ConsultationSchedule consultationSchedule,
            RedirectAttributes redirectAttributes) {
        
    	// 기존 데이터 조회
        Optional<ConsultationSchedule> optionalSchedule = consultationScheduleService.getScheduleById(id);

        if (optionalSchedule.isPresent()) {
            ConsultationSchedule existingSchedule = optionalSchedule.get();

            // 데이터 업데이트
            existingSchedule.setName(consultationSchedule.getName());
            existingSchedule.setEmail(consultationSchedule.getEmail());
            existingSchedule.setTel(consultationSchedule.getTel());
            existingSchedule.setCell(consultationSchedule.getCell());
            existingSchedule.setReservationDate(consultationSchedule.getReservationDate());
            existingSchedule.setReservationTime(consultationSchedule.getReservationTime());
            existingSchedule.setEtc(consultationSchedule.getEtc());
            existingSchedule.setCenter(consultationSchedule.getCenter());
            existingSchedule.setEduKind(consultationSchedule.getEduKind());
            existingSchedule.setEdutype(consultationSchedule.getEdutype());

            // 저장
            consultationScheduleService.save(existingSchedule);

            // 성공 메시지 추가
            redirectAttributes.addFlashAttribute("successMessage", "상담 일정이 성공적으로 수정되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "해당 상담 일정 수정에 실패하였습니다.");
        }

        // 수정 후 목록 페이지로 이동
        return "redirect:/schedules";
    }
    

    @GetMapping("/consultation_delete/{id}")
    public String deleteConsultation(@PathVariable("id") Integer id) {
        consultationScheduleService.deleteById(id); // 서비스 호출
        return "redirect:/consultations"; // 삭제 후 목록으로 리다이렉트
    }
    
    
     
}//class
