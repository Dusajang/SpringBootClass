package org.sist.sist_project.consultationSchedule;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ConsultationScheduleController {

    private final ConsultationScheduleService consultationScheduleService;

    @GetMapping("/schedules")
    public String getAllSchedules(Model model) {
        model.addAttribute("schedules", consultationScheduleService.getAllSchedules());
        return "consultation_list";
    }
}
